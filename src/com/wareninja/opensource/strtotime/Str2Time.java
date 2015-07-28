/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@wareninja.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */

package com.wareninja.opensource.strtotime;

import com.wareninja.opensource.strtotime.matcher.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * source adapted & extended from: http://stackoverflow.com/questions/1268174/phps-strtotime-in-java
 * 
 * example usage:
 * Date now = Str2Time.convert("now");
 * Date tomorrow = Str2Time.convert("tomorrow");
 * Date bla1 = Str2Time.convert("3 days");
 * Date bla2 = Str2Time.convert("-3 days");
 */
public final class Str2Time {
	
    private static final List<Matcher> matchers;
    private static final List<Matcher> matchersFull;

    static {
        matchersFull = new LinkedList<Matcher>();

        matchersFull.add(new DateFormatMatcher(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")));// format used by FACEBOOK
        matchersFull.add(new DateFormatMatcher(new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")));
        matchersFull.add(new DateFormatMatcher(new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z")));
        matchersFull.add(new DateFormatMatcher(new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss")));// e.g. Mon, 03 Dec 2012 20:00:00
        matchersFull.add(new DateFormatMatcher(new SimpleDateFormat("EEE MMM d HH:mm:ss Z yyyy"))); // format used by TWITTER! e.g. "Mon Sep 24 03:35:21 +0000 2012"

        matchers = new LinkedList<Matcher>();
        // set full date
        matchers.add(new NowMatcher());
        matchers.add(new TomorrowMatcher());
        matchers.add(new YesterdayMatcher());
        matchers.add(new DateMatcher());

        // add/sup
        matchers.add(new DaysMatcher());
        matchers.add(new WeeksMatcher());
        matchers.add(new YearsMatcher());
        matchers.add(new MinutesMatcher());

        // set time
        matchers.add(new TimeMatcher());


        // NOTE: you can add more custom matchers as you like!!!
    }

    public static void registerMatcher(Matcher matcher) {
        matchers.add(0, matcher);
    }
    
    public static Date convert(String input) {
    	return convert(input, null);
    }
    public static Date convert(String input, Date refDate) {
        Calendar calendar = Calendar.getInstance();
        if(refDate != null) {
            calendar.setTime(refDate);
        }

        Boolean success = false;
        input = input.toLowerCase(Locale.ENGLISH).trim();

        for (Matcher matcher : matchersFull) {
            if(matcher.tryConvert(input, calendar)) {
                return calendar.getTime();
            }
        }

        for (Matcher matcher : matchers) {
            if(matcher.tryConvert(input, calendar)) {
                success = true;
                // @todo refactor
                if(matcher.getStringWithoutMatch() != null) {
                    input = matcher.getStringWithoutMatch();
                }
            }
        }

        if(success){
            return calendar.getTime();
        }

        return null;
    }

    private Str2Time() {
        throw new UnsupportedOperationException("cannot instantiate");
    }
}
