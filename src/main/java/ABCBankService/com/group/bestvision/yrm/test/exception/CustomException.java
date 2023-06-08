/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
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
