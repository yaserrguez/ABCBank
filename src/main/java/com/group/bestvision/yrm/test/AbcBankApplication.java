/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:35 AM
 *
 */

package com.group.bestvision.yrm.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AbcBankApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(AbcBankApplication.class, args);
    }

}
