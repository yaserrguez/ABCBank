/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException( String message)
    {
        super(message);
    }
}