/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/26/23, 12:14 PM
 *
 */

package com.group.bestvision.yrm.test.actuator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("actuator")
@Qualifier("customTraceRepository")
public class CustomTraceRepository implements HttpTraceRepository
{

//    AtomicReference<HttpTrace> lastTrace = new AtomicReference<>();
    List<HttpTrace> lastTrace = new ArrayList<>();

    @Override
    public List<HttpTrace> findAll()
    {
//        return Collections.singletonList(lastTrace.get());
        return lastTrace;
    }

    @Override
    public void add(HttpTrace trace)
    {
        if ("GET".equals(trace.getRequest().getMethod()))
        {
            //            lastTrace.set(trace);
            if (lastTrace.size() == 5)
            {
                lastTrace.remove(0);
            }
            lastTrace.add(trace);
        }
    }

}
