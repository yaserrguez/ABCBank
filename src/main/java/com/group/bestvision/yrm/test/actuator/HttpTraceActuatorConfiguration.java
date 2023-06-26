/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/26/23, 12:14 PM
 *
 */

package com.group.bestvision.yrm.test.actuator;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("actuator")
public class HttpTraceActuatorConfiguration
{

//    @Bean
//    public HttpTraceRepository httpTraceRepository()
//    {
//        return new InMemoryHttpTraceRepository();
//    }

}
