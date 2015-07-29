/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@dnap.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */

package com.dnap.opensource.stringToDate.matcher_ru;

import com.dnap.opensource.stringToDate.matcher.Matcher;

import java.util.Calendar;
import java.util.regex.Pattern;

public class TomorrowMatcher extends Matcher {

    private final Pattern tomorrow = Pattern.compile("завтра");

    public Boolean tryConvert(String input, Calendar calendar) {
        if (tomorrow.matcher(input).find()) {
            calendar.add(Calendar.DAY_OF_YEAR, +1);
            return true;
        } else {
            return false;
        }
    }
}
