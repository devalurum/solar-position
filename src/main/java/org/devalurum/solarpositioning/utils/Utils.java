package org.devalurum.solarpositioning.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@UtilityClass
public class Utils {
    public static final String DATE_FORMAT_DD_MM_YYYY_HH_MM_SS = "dd.MM.yyyy HH:mm:ss";
    public static final String ZONED_DT_PATTERN = "dd.MM.yyyy HH:mm:ss Z";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT_DD_MM_YYYY_HH_MM_SS);
    public static final DateTimeFormatter ZONED_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(ZONED_DT_PATTERN);

    public static String format(LocalDateTime date, String format) {
        if (date == null) {
            return "";
        }
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
        return dateFormat.format(date);
    }

    public static LocalDateTime parse(String date, String format) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(date, Utils.DATE_TIME_FORMATTER);
    }

    public static boolean nonNull(Object value) {
        return !isNull(value);
    }

    public static boolean isNull(Object value) {
        return Objects.isNull(value);
    }


}
