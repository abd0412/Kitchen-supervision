package cn.gxhunter.tourism.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static String DATE_FORMAT_TYPE= "yyyy-MM-dd HH:mm:ss";

    /**
     * 10位13位时间戳转String 格式（2018-10-15 16:03:27） 日期
     * @param timestamp
     * @return
     */
    public static String timestampToString(String timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TYPE);//要转换的时间格式
        String date = null;
        if (timestamp.length() == 13) {
            date = sdf.format(Long.parseLong(timestamp));
        } else {
            date = sdf.format(Long.parseLong(timestamp) * 1000);
        }
        return date;
    }

    /**
     *  10位13位时间戳转Date
     * @param timestamp 参数时间戳
     * @return
     */
    public static Date timestampToDate(String timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TYPE);//要转换的时间格式
        Date date = null;
        try {
            if (timestamp != null && timestamp.length() == 13) {
                date = sdf.parse(sdf.format(Long.parseLong(timestamp)));
            } else if (timestamp != null && timestamp.length() == 10){
                date = sdf.parse(sdf.format(Long.parseLong(timestamp) * 1000));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Date转10位13位时间戳
     * @param date  参数date
     * @param n     需要转换成几位时间戳
     * @return
     */
    public static String dateToTimestamp(Date date,int n){
        String result = null;
        if (n == 13){
            result = String.valueOf(date.getTime());
        }else {
            result = String.valueOf(date.getTime()/1000);
        }
        return  result;
    }

 }