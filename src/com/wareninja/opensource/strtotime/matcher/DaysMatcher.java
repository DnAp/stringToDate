/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@wareninja.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */

package com.wareninja.opensource.strtotime.matcher;

import java.util.Calendar;
import java.util.regex.Pattern;

public class DaysMatcher extends Matcher {

    private final Pattern days = Pattern.compile("([\\-\\+]?\\d+) day[s]?");

    public Boolean tryConvert(String input, Calendar refDate) {

        java.util.regex.Matcher matcher = days.matcher(input);

    	if (matcher.find()) {
            int d = Integer.parseInt(matcher.group(1));
            refDate.add(Calendar.DAY_OF_YEAR, d);
            return true;
        }

        return false;
    }
}
