/*
 * Copyright (c) 2022. DATYS, Tecnología y Servicios.
 * SRNT Sistema de Registro Nacional de Tramites
 * Todos los derechos reservados.
 * www.datys.co.cu
 *
 * LastUpdate: 3/29/22, 12:24 PM.
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.exception;

import org.springframework.stereotype.Component;

@Component
public class CustomException
{
    public static ResourceNotFoundException notFoundException(String message)
    {
        return new ResourceNotFoundException(message);
    }

    public static ResourceValidationException validationException(String message)
    {
        return new ResourceValidationException(message);
    }

    public static ResourceInternalException internalException(String message)
    {
        return new ResourceInternalException(message);
    }
}
