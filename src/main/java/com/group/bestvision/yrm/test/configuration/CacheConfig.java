/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:35 AM
 *
 */

package com.group.bestvision.yrm.test.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
@EnableCaching
public class CacheConfig
{
    public CacheConfig()
    {
        //Para Spring
    }

    @Bean
    public KeyGenerator multiplyKeyGenerator()
    {
        return (Object target, Method method, Object... params) ->
                method.getName() + "_" + Arrays.toString(params);
    }
}
