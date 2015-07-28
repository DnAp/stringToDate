/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@wareninja.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */

package com.wareninja.opensource.strtotime.matcher;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class YesterdayMatcher extends Matcher {

    private final Pattern yesterday = Pattern.compile("yesterday");

    public Boolean tryConvert(String input, Calendar calendar) {
        if (yesterday.matcher(input).matches()) {
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            return true;
        } else {
            return false;
        }
    }
}
