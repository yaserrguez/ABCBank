/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:custom.properties")
public class PropertiesConfig
{
	
	@Autowired
    private Environment env;

    public String getConfigValue( String configKey )
    {
        String property = env.getProperty(configKey);
        return (property == null)? "" : property;
    }

}
