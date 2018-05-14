package com.markuione.helper;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by anish on 18-10-2017.
 */

public class FunctionHelper {

    public static float dpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static float pixelToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public static List<String> getDaysBetweenDates(Date startdate, Date enddate, String format) {
        List<Date> dates = new ArrayList<Date>();
        List<String> dateStrings = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startdate);

        while (calendar.getTime().before(enddate)) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                calendar.add(Calendar.DATE, 1);
                continue;
            }

            Date result = calendar.getTime();
            dates.add(result);
            dateStrings.add(formatDate(result, format));
            calendar.add(Calendar.DATE, 1);
        }
        return dateStrings;
    }

    public static String formatDate(Date date, String type) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(type, Locale.US);
            return df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
