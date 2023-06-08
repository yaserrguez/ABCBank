/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.utils;

import ABCBankService.com.group.bestvision.yrm.test.exception.CustomException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PaginAndSortingUtils
{
    public static Sort getSortOrder(String order, Class specificEntityClass)
    {
        if (order == null || order.isEmpty())
        {
            return null;
        }

        if (specificEntityClass == null)
        {
            return getSortOrder(order);
        }

        Sort.Direction direction = Sort.DEFAULT_DIRECTION;
        String fieldname = order;

        if (order.charAt(0) == '-')
        {
            direction = Sort.Direction.DESC;
            fieldname = order.substring(1);
        }
        else
        {
            if (order.charAt(0) == '+')
            {
                //direction = Sort.Direction.ASC;
                fieldname = order.substring(1);
            }
        }
        try
        {
            boolean propertieFound = false;
            Field[] properties = specificEntityClass.getDeclaredFields(); // Atributos
            for (int i = 0; i < properties.length; i++)
            {
                Field field = properties[i];
                if (field.getName().equals(fieldname))
                {
                    propertieFound = true;
                    break;
                }
            }
            if (!propertieFound)
            {
                String getmetod = "get" + String.valueOf(fieldname.charAt(0)).toUpperCase() + order.substring(1);
                Method[] methods = specificEntityClass.getDeclaredMethods(); //Metodos
                for (int i = 0; i < methods.length; i++)
                {
                    Method metod = methods[i];
                    if (metod.getName().equals(getmetod))
                    {
                        propertieFound = true;
                        break;
                    }
                }
            }

            if (!propertieFound)
            {
                Class<?> superClass = specificEntityClass.getSuperclass(); // Clase padre
                if (superClass != null)
                {
                    Field[] superProperties = superClass.getDeclaredFields(); // Atributos
                    for (int i = 0; i < superProperties.length; i++)
                    {
                        Field field = superProperties[i];
                        if (field.getName().equals(fieldname))
                        {
                            propertieFound = true;
                            break;
                        }
                    }
                    if (!propertieFound)
                    {
                        String getmetod = "get" + String.valueOf(fieldname.charAt(0)).toUpperCase() + fieldname.substring(1);
                        if (!propertieFound)
                        {
                            Method[] superMethods = superClass.getDeclaredMethods(); //Metodos
                            for (int i = 0; i < superMethods.length; i++)
                            {
                                Method method = superMethods[i];
                                if (method.getName().equals(getmetod))
                                {
                                    propertieFound = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (!propertieFound)
            {
                throw CustomException.validationException("Order no valido. Propiedad '" + fieldname + "' no encontrada.");
            }

            return Sort.by(direction, fieldname);
        }
        catch (Exception e)
        {
            throw CustomException.validationException("Order no valido.");
        }
    }

    public static Sort getSortOrder(String order)
    {
        if (order == null || order.isEmpty())
        {
            return null;
        }

        Sort.Direction direction = Sort.DEFAULT_DIRECTION;
        String fieldname = order;

        if (order.charAt(0) == '-')
        {
            direction = Sort.Direction.DESC;
            fieldname = order.substring(1);
        }
        else
        {
            if (order.charAt(0) == '+')
            {
                //direction = Sort.Direction.ASC;
                fieldname = order.substring(1);
            }
        }

        return Sort.by(direction, fieldname);
    }

    public static Pageable gatPageable(Integer pageNumber, Integer itemsPerPage, String order, Class specificEntityClass)
    {
        if (pageNumber == null && itemsPerPage == null)
        {
            return null;
        }
        if (pageNumber != null || itemsPerPage != null)
        {
            pageNumber = (pageNumber == null) ? 0 : pageNumber; // valores por defecto
            itemsPerPage = (itemsPerPage == null) ? 5 : itemsPerPage; // valores por defecto
        }
        if (pageNumber < 0 || itemsPerPage <= 0)
        {
            throw CustomException.validationException("Paginacion no valida.");
        }

        Sort sortOrder = getSortOrder(order, specificEntityClass);

        return (sortOrder == null)? PageRequest.of(pageNumber, itemsPerPage) : PageRequest.of(pageNumber, itemsPerPage, sortOrder);
    }

    public static Pageable gatPageable(Integer pageNumber, Integer itemsPerPage)
    {
        if (pageNumber == null && itemsPerPage == null)
        {
            return null;
        }
        if (pageNumber != null || itemsPerPage != null)
        {
            pageNumber = (pageNumber == null) ? 0 : pageNumber; // valores por defecto
            itemsPerPage = (itemsPerPage == null) ? 5 : itemsPerPage; // valores por defecto
        }
        if (pageNumber < 0 || itemsPerPage <= 0)
        {
            throw CustomException.validationException("Paginacion no valida.");
        }

        return PageRequest.of(pageNumber, itemsPerPage);
    }
}
