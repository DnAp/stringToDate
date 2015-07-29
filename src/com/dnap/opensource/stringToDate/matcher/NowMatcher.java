/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@dnap.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */

package com.dnap.opensource.stringToDate.matcher;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class NowMatcher extends Matcher {

    private static final Pattern now = Pattern.compile("\\W*now\\W*");
    private static final Pattern today = Pattern.compile("\\W*today\\W*");

    public Boolean tryConvert(String input, Calendar refDate) {
        if (now.matcher(input).find() || today.matcher(input).find()) {
            refDate.setTime(new Date());
            return true;
        } else {
            return false;
        }
    }
}
