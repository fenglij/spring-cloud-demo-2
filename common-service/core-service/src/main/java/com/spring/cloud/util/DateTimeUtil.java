package com.spring.cloud.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final String DEFAULT_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("Asia/Shanghai");


    /**
     * 时间戳转时间字符串
     * @param timestamp
     * @return
     */
    public static String formatTimestamp2Str(Long timestamp){
        return formatTimestamp2Str(timestamp, DEFAULT_FORMATTER);
    }

    /**
     * 时间戳转时间字符串
     * @param timestamp
     * @param formatter
     * @return
     */
    public static String formatTimestamp2Str(Long timestamp, String formatter){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp),
                ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(formatter));
    }

    /**
     * 时间字符串转时间戳
     * @param dateTime
     * @return
     */
    public static Long parseStr2Timestamp(String dateTime){
        return parseStr2Timestamp(dateTime, DEFAULT_FORMATTER);
    }

    /**
     * 时间字符串转时间戳
     * @param dateTime
     * @param formatter
     * @return
     */
    public static Long parseStr2Timestamp(String dateTime, String formatter){
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(formatter));
        Instant instant = localDateTime.atZone(DEFAULT_ZONE_ID).toInstant();
        return instant.toEpochMilli();
    }

    public static void main(String[] args){
        System.out.println(formatTimestamp2Str(1534843900l));
        System.out.println(parseStr2Timestamp("2018-08-21 17:31:40"));
    }

}
