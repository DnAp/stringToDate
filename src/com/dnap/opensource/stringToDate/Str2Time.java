/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@dnap.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */

package com.dnap.opensource.stringToDate;

import com.dnap.opensource.stringToDate.matcher.*;
import com.dnap.opensource.stringToDate.matcher_ru.StringToNumberMatcher;

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
public class Str2Time {

    private List<Matcher> matchers;
    private List<Matcher> matchersFull;
    private Locale locale;

    public Str2Time() {
        this(Locale.ENGLISH);
    }

    public Str2Time(Locale locale) {
        this.locale = locale;
        if(locale.getLanguage().equalsIgnoreCase("en")) {
            initEnLocale();
        }
        if(locale.getLanguage().equalsIgnoreCase("ru")) {
            initRuLocale();
        }
    }

    private void initEnLocale()
    {
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
    }


    private void initRuLocale()
    {
        matchersFull = new LinkedList<Matcher>();

        matchers = new LinkedList<Matcher>();
        matchers.add(new StringToNumberMatcher());
        // set full date
        matchers.add(new com.dnap.opensource.stringToDate.matcher_ru.NowMatcher());
        matchers.add(new com.dnap.opensource.stringToDate.matcher_ru.BeforeYesterdayMatcher());
        matchers.add(new com.dnap.opensource.stringToDate.matcher_ru.AfterTomorrowMatcher());
        matchers.add(new com.dnap.opensource.stringToDate.matcher_ru.TomorrowMatcher());
        matchers.add(new com.dnap.opensource.stringToDate.matcher_ru.YesterdayMatcher());
        matchers.add(new DateMatcher());

        // add/sup
        matchers.add(new com.dnap.opensource.stringToDate.matcher_ru.MonthsMatcher());
        matchers.add(new com.dnap.opensource.stringToDate.matcher_ru.DaysMatcher());
        matchers.add(new com.dnap.opensource.stringToDate.matcher_ru.WeeksMatcher());
        matchers.add(new com.dnap.opensource.stringToDate.matcher_ru.YearsMatcher());
        matchers.add(new com.dnap.opensource.stringToDate.matcher_ru.MinutesMatcher());

        // set time
        matchers.add(new TimeMatcher());
    }

    public Date convert(String input) {
    	return convert(input, null);
    }
    public Date convert(String input, Date refDate) {
        Calendar calendar = Calendar.getInstance();
        if(refDate != null) {
            calendar.setTime(refDate);
        }

        Boolean success = false;
        input = input.toLowerCase(locale).trim();

        for (Matcher matcher : matchersFull) {
            if(matcher.tryConvert(input, calendar)) {
                return calendar.getTime();
            }
        }

        for (Matcher matcher : matchers) {
            if(matcher.tryConvert(input, calendar)) {
                success = true;
                //System.out.println(matcher);
                // @todo refactor
                if(matcher.getStringWithoutMatch() != null) {
                    input = matcher.getStringWithoutMatch();
                }
            }
        }
        //System.out.println(input);

        if(success){
            return calendar.getTime();
        }

        return null;
    }

}