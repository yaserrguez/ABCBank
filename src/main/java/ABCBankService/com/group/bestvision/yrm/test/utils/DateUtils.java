/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 11:44 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class DateUtils
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(DATE_PATTERN);

    private DateUtils()
    {
        super();
    }

    public static Date today()
    {
        return new Date();
    }

    public static Date getBefore(Date referenceDate, int time)
    {
        LocalDate date = referenceDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        TemporalUnit unidadTemporal = ChronoUnit.YEARS;
        LocalDate dateResultado=date.minus(time,unidadTemporal);
        return Date.from(dateResultado.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
