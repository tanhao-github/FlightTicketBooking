package com.jinshuju.utils;

import com.jinshuju.enums.DateTypeEnum;
import com.sun.tools.javac.util.Assert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author tanchaowen
 */
public class CommUtils {

    /**
     * 获取日期类型枚举
     *
     * @param dateStr
     * @return
     */
    public static DateTypeEnum getDateTypeEnumByDateStr(String dateStr){
        Assert.checkNonNull(dateStr,"日期不能为空,格式：20200328");
        int dayOfWeek = getDayOfWeek(getDateByStr(dateStr,"yyyyMMdd"));
        if(dayOfWeek == 1 || dayOfWeek == 7){
            return DateTypeEnum.WEEKENDS;
        }else {
            return DateTypeEnum.WEEKDAYS;
        }
    }

    /**
     * 获取日期是星期几
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date){
        Assert.checkNonNull(date,"日期不能为空");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 日期字符串转为Date类型
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date getDateByStr(String dateStr, String pattern) {
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        Date date;
        try {
            date = sd.parse(dateStr);
        } catch (ParseException e) {
            date = null;
            e.printStackTrace();
        }
        return date;
    }

}