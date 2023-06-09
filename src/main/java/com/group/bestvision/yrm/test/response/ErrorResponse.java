/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.response;

import com.group.bestvision.yrm.test.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Component
public class ErrorResponse implements Serializable
{
    private final int code;
    private final String message;
    private final String details;
    private Date timestamp;

    public ErrorResponse()
    {
        this(500, "Error interno");
    }

    public ErrorResponse(int code, String message, String details)
    {
        this.code = code;
        this.message = message;
        this.details = details;
        this.timestamp = DateUtils.today();
    }

    public ErrorResponse(String details)
    {
        this(500, "Error interno", details, DateUtils.today());
    }

    public ErrorResponse(int code, String message)
    {
        this(code, message, null, DateUtils.today());
    }

    public ErrorResponse(HttpStatus code, String details)
    {
        this(code.value(), code.toString(), details, DateUtils.today());
    }

    public ErrorResponse(HttpStatus code)
    {
        this(code.value(), code.toString(), null, DateUtils.today());
    }


}
