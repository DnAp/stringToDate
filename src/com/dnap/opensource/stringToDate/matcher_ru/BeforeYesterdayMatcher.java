/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@dnap.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */

package com.dnap.opensource.stringToDate.matcher_ru;

import com.dnap.opensource.stringToDate.matcher.Matcher;
import org.apache.commons.lang.StringUtils;

import java.util.Calendar;
import java.util.regex.Pattern;

public class BeforeYesterdayMatcher extends Matcher {

    private final Pattern yesterday = Pattern.compile("поза[ ]*вчера");

    public Boolean tryConvert(String input, Calendar calendar) {
        java.util.regex.Matcher matcher = yesterday.matcher(input);
        if (matcher.find()) {
            calendar.add(Calendar.DAY_OF_YEAR, -2);
            stringWithoutMatch = StringUtils.replace(input, matcher.group(), "");
            return true;
        }
        stringWithoutMatch = null;
        return false;
    }
}
