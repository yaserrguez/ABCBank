/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.utils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
}
