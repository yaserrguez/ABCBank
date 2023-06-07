/*
 * Copyright (c) 2022. DATYS, Tecnología y Servicios.
 * SRNT Sistema de Registro Nacional de Tramites
 * Todos los derechos reservados.
 * www.datys.co.cu
 *
 * LastUpdate: 11/5/22 11:30.
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.utils;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListToStringConverter implements AttributeConverter<List<String>, String>
{
    @Override
    public String convertToDatabaseColumn(List<String> attribute)
    {
        return attribute == null ? null : String.join(",",attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData)
    {
        return dbData == null ? Collections.emptyList() : Arrays.asList(dbData.split(","));
    }
}
