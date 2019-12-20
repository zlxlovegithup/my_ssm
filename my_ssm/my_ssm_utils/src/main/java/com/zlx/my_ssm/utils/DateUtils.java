package com.zlx.my_ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期和字符串相互转换的工具类
 */
public class DateUtils {

    /**
     * 日期转换为字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //将Date类型转换成String类型
        String format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 将字符串类型的日期转换为日期格式的日期
     * @param dateStr
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String dateStr,String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //将String类型的日期转换为日期格式的日期
        Date date = simpleDateFormat.parse(dateStr);
        return date;
    }
}
