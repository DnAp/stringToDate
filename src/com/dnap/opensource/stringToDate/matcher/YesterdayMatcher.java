/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@dnap.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */

package com.dnap.opensource.stringToDate.matcher;

import java.util.Calendar;
import java.util.regex.Pattern;

public class YesterdayMatcher extends Matcher {

    private final Pattern yesterday = Pattern.compile("yesterday");

    public Boolean tryConvert(String input, Calendar calendar) {
        java.util.regex.Matcher matcher = yesterday.matcher(input);
        if (matcher.find()) {
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            stringWithoutMatch = matcher.replaceFirst("");
            return true;
        }
        stringWithoutMatch = null;
        return false;
    }
}
