/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * The type Date utils.
 */
public class DateUtils
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * The constant DATE_PATTERN.
     */
    public static final String DATE_PATTERN = "dd/MM/yyyy";
    /**
     * The constant DTF.
     */
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(DATE_PATTERN);

    private DateUtils()
    {
        super();
    }

    /**
     * Today date.
     *
     * @return the date
     */
    public static Date today()
    {
        return new Date();
    }

    /**
     * Gets before.
     *
     * @param referenceDate the reference date
     * @param time          the time
     * @return the before
     */
    public static Date getBefore(Date referenceDate, int time)
    {
        LocalDate date = referenceDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        TemporalUnit unidadTemporal = ChronoUnit.YEARS;
        LocalDate dateResultado=date.minus(time,unidadTemporal);
        return Date.from(dateResultado.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
