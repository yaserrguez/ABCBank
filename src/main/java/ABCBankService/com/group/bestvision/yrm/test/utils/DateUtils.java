package ABCBankService.com.group.bestvision.yrm.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class DateUtils
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern(DATE_PATTERN);

    private DateUtils()
    {
        super();
    }

    /**
     * Retorna ahora en un objeto {@link LocalDateTime}
     *
     * @return
     */
    public static LocalDateTime now()
    {
        return LocalDateTime.now();
    }

    /**
     * Retorna ahora en un objeto {@link String}
     *
     * @return
     */
    public static String nowStr()
    {
        return now().format(DTF);
    }

    /**
     * @param input
     * @return
     */
    public static LocalDateTime fromStr2DateTime(String input)
    {
        return fromStr2DateTime(input, DATE_PATTERN);
    }

    /**
     * @param input
     * @param pattern
     * @return
     */
    public static LocalDateTime fromStr2DateTime(String input, String pattern)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(input, dtf);
        return date.atStartOfDay();
    }

    /**
     * Retorna la fecha pasada en el formato definido
     *
     * @param date
     * @return
     */

    public static String formattedDate(LocalDateTime date)
    {
        return Optional.ofNullable(date).orElse(now()).format(DTF);
    }

    /**
     * Retorna si la fecha es valida con el formato dd/mm/yyyy
     *
     * @param fecha
     * @return
     */
    public static boolean isValid(String fecha)
    {
        try
        {
            convertir(fecha, DateTimeFormatter.ofPattern(DATE_PATTERN));
        }
        catch (Exception ex)
        {
            return false;
        }
        return true;
    }

    /**
     * Convierte a LocalDate la fecha de String con formato determinado
     *
     * @param fecha
     * @param formato
     * @return
     */
    public static LocalDate convertir(String fecha, DateTimeFormatter formato)
    {
        return LocalDate.parse(fecha, formato);
    }

    /**
     * Convierte a LocalDate la fecha de String
     *
     * @param fecha
     * @return
     */
    public static LocalDate convertir(String fecha)
    {
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern(DATE_PATTERN));
    }


    /**
     * Returns today's date as java.util.Date object
     *
     * @return today's date as java.util.Date object
     */
    public static Date today()
    {
        return new Date();
    }

    /**
     * Returns today's date as dd/MM/yyyy format
     *
     * @return today's date as dd/MM/yyyy format
     */
    public static String todayStr()
    {
        return sdf.format(today());
    }

    /**
     * Returns the formatted String date for the passed java.util.Date object
     *
     * @param date
     * @return
     */
    public static String formattedDate(Date date)
    {
        return date != null ? sdf.format(date) : todayStr();
    }

    public static LocalDateTime convertirToLocalDateTime(Date fecha)
    {
        return LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Convierte String a LocalDateTime con formato dd/MM/yyyy
     *
     * @param fecha
     * @return
     */
    public static LocalDateTime convertStrToLocalDateTime(String fecha)
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        // Convert String to LocalDateTime using LocalDate's parse() method
        LocalDateTime localDateTime = LocalDate.parse(fecha, dateTimeFormatter).atStartOfDay();
        return localDateTime;
    }

    public static Date formattedStringToDate(String strDate)
    {

        try
        {

            return new SimpleDateFormat("dd/MM/yyyy").parse(strDate);

        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return null;

    }

    public static LocalDate formattedStringToLocalDate(String strDate)
    {

        return LocalDate.parse(strDate, DTF);

    }

    public static Boolean isValidDate(String date)
    {

        return formattedStringToDate(date) != null;

    }

    public static Boolean validateRangeDates(String fechaIni, String fechaFin)
    {

        Date fecha1 = formattedStringToDate(fechaIni);
        Date fecha2 = formattedStringToDate(fechaFin);

        if (fecha1 != null && fecha2 != null) {return !fecha1.after(fecha2);}

        return false;

    }

    public static Date strToDate(String date)
            throws ParseException
    {
        return date != null ? sdf.parse(date) : null;
    }

    public static Date strToDate(String date, String format)
            throws ParseException
    {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        return date != null ? formater.parse(date) : null;
    }

    /**
     * Return the file name with actual date
     *
     * @param fileName
     * @return
     */
    public static String generateFileName(String fileName) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        fileName = fileName + "_" + date.format(formatter) + ".xlsx";
        return fileName;
    }
}
