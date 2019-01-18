package com.alice.alicepic.until;

import java.util.Calendar;
import java.util.Date;

public class TimeType {

    public static String getLastSendMessageTimeText(long time) {
        Calendar calendar = Calendar.getInstance();
        long now = calendar.getTime().getTime();
        if (now - time < 86400000) {
            int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.setTime(new Date(time));
            int sendDay = calendar.get(Calendar.DAY_OF_MONTH);
            if (nowDay==sendDay){
                return "今天发布";
            }else {
                return "昨天发布";
            }
        } else if (now - time > 86400000 && now - time < 604800000) {
            calendar.setTime(new Date(time));
            String dayOfWeekText;
            switch (calendar.get(Calendar.DAY_OF_WEEK) - 1) {
                case 0:
                    dayOfWeekText = "星期日发布";
                    break;
                case 1:
                    dayOfWeekText = "星期一发布";
                    break;
                case 2:
                    dayOfWeekText = "星期二发布";
                    break;
                case 3:
                    dayOfWeekText = "星期三发布";
                    break;
                case 4:
                    dayOfWeekText = "星期四发布";
                    break;
                case 5:
                    dayOfWeekText = "星期五发布";
                    break;
                case 6:
                    dayOfWeekText = "星期六发布";
                    break;
                default:
                    dayOfWeekText = "";
            }
            return dayOfWeekText;
        } else {
            int nowYear = calendar.get(Calendar.YEAR);
            calendar.setTime(new Date(time));
            int sendYear = calendar.get(Calendar.YEAR);
            if (nowYear > sendYear) {
                return sendYear + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
            }
            return (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        }
    }
}
