package com.dnap.opensource.stringToDate.matcher_ru;

import com.dnap.opensource.stringToDate.matcher.Matcher;

import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Created by dnap on 29.07.15. strtotime-for-java
 */
public class HoursMatcher extends Matcher {

    private final Pattern hour = Pattern.compile("(([\\-\\+]?\\d+)\\s+|)(часа|часом|часов|часах|час)\\s*((ночь|ночи)|(дня|вечера)|(утра)|)");

    @Override
    public Boolean tryConvert(String input, Calendar calendar) {
        java.util.regex.Matcher matcher = hour.matcher(input);
        if (matcher.find()) {

            int h = 1;
            if (matcher.group(2) != null) {
                h = Integer.parseInt(matcher.group(2));
            }
            if (h > 12) { // 13..23
                calendar.set(Calendar.HOUR_OF_DAY, h);
            } else {
                // if(matcher.group(5) != null) // ночи skip
                if (matcher.group(6) != null) { // вечера|дня
                    h += 12;
                } else if (matcher.group(7) != null) { // утра
                    if (h < 3) { // час утра, 2 часа утра => это день
                        h += 12;
                    }
                }

                calendar.set(Calendar.HOUR_OF_DAY, h);
            }

            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);

            if(isFuture() && calendar.before(Calendar.getInstance())) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }

            stringWithoutMatch = matcher.replaceFirst("");
            return true;
        }
        stringWithoutMatch = null;

        return false;
    }

}