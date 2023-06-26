/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/26/23, 12:14 PM
 *
 */

package com.group.bestvision.yrm.test.actuator;

import org.springframework.boot.actuate.trace.http.HttpExchangeTracer;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.web.trace.servlet.HttpTraceFilter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Component
@Profile("actuator")
public class TraceRequestFilter extends HttpTraceFilter
{

    public TraceRequestFilter(HttpTraceRepository repository, HttpExchangeTracer tracer)
    {
        super(repository, tracer);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException
    {
        return request.getServletPath().contains("actuator");
    }
}
