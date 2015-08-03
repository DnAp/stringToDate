/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@wareninja.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */


import com.dnap.opensource.stringToDate.MyUtils;
import com.dnap.opensource.stringToDate.Str2Time;

import java.util.Locale;

public class ExampleUsage {

	/*
	 * example usage:
	 * Date now = Str2Time.convert("now");
	 * Date tomorrow = Str2Time.convert("tomorrow");
	 * Date bla1 = Str2Time.convert("3 days");
	 * Date bla2 = Str2Time.convert("-3 days");
	 * 
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Str2Time str2Time = new Str2Time();
		if(false) {

			System.out.println("NOW -> " + MyUtils.getFormattedDate(str2Time.convert("NOW")));
			System.out.println("now -1 day -> " + MyUtils.getFormattedDate(str2Time.convert("now -1 day")));

			System.out.println("tomorrow -> " + MyUtils.getFormattedDate(str2Time.convert("tomorrow")));
			System.out.println("yesterday -> " + MyUtils.getFormattedDate(str2Time.convert("yesterday")));
			System.out.println("+80 minutes -> " + MyUtils.getFormattedDate(str2Time.convert("80 minutes")));
			System.out.println("-160 minutes -> " + MyUtils.getFormattedDate(str2Time.convert("-160 minutes")));
			System.out.println("+8 days -> " + MyUtils.getFormattedDate(str2Time.convert("8 days")));
			System.out.println("-16 days -> " + MyUtils.getFormattedDate(str2Time.convert("-16 days")));
			System.out.println("+2 weeks -> " + MyUtils.getFormattedDate(str2Time.convert("2 weeks")));
			System.out.println("-4 weeks -> " + MyUtils.getFormattedDate(str2Time.convert("-4 weeks")));
			System.out.println("Mon Sep 24 03:35:21 +0000 2012 -> " + MyUtils.getFormattedDate(str2Time.convert("Mon Sep 24 03:35:21 +0000 2012"))); // @todo fixme

			parseTest(str2Time, "2015-03-12 23:50:59");
			parseTest(str2Time, "2015-3-12 23:49");
			parseTest(str2Time, "2015-03-12");
			parseTest(str2Time, "20150312");
			parseTest(str2Time, "20150312 +2 DAY");
			parseTest(str2Time, "2015-03-12 11 45");
			parseTest(str2Time, "today 10:30");
			parseTest(str2Time, "tomorrow at 11:45:00");
			parseTest(str2Time, "yesterday at 11:45");
			parseTest(str2Time, "today at 11 45");

		}
		str2Time = new Str2Time(new Locale("ru", "RU"));

		parseTest(str2Time, "2015-03-12 23:50:59");
		parseTest(str2Time, "2015-3-12 23:49");
		parseTest(str2Time, "2015-03-12");
		parseTest(str2Time, "20150312");
		parseTest(str2Time, "20150312 +2 ДНЯ");
		parseTest(str2Time, "2015-03-12 11 45");
		parseTest(str2Time, "сейчас");
		parseTest(str2Time, "завтра 10:30");
		parseTest(str2Time, "завтра в 10 30");
		parseTest(str2Time, "послезавтра в 10:30");
		parseTest(str2Time, "вчера в 11:45");
		parseTest(str2Time, "позавчера в 11:45:00");
		parseTest(str2Time, "сегодня в 11 45"); // !
		parseTest(str2Time, "20 сентября в 11 45");
		parseTest(str2Time, "в сентября в 11 45");
		parseTest(str2Time, "сентября");
		parseTest(str2Time, "сентября в 3 40 30");
		parseTest(str2Time, "февраль");
		parseTest(str2Time, "10 00");
		parseTest(str2Time, "в 10");
		parseTest(str2Time, "в 10 часов вечера");
		parseTest(str2Time, "час дня");
		parseTest(str2Time, "час ночи");
		parseTest(str2Time, "2 часа");
		parseTest(str2Time, "2 ночи");
		parseTest(str2Time, "в 10 часов утра");
		parseTest(str2Time, "сегодня ночью");
		parseTest(str2Time, "завтра ночью");
		parseTest(str2Time, "завтра в два");
		parseTest(str2Time, "через 2 недели");
		parseTest(str2Time, "через 2 недели и один день");
		parseTest(str2Time, "через час");
		parseTest(str2Time, "через 2 дня днем");
		parseTest(str2Time, "через 2 дня утром");
		parseTest(str2Time, "завтра через 2 часа qwert");
		parseTest(str2Time, "через 30 минут");
		parseTest(str2Time, "через 4 дня");
		parseTest(str2Time, "в воскресенье");
		parseTest(str2Time, "в понедельник");
		parseTest(str2Time, "в среду");
		parseTest(str2Time, "го в сб тусить");
		parseTest(str2Time, "через неделю");
		parseTest(str2Time, "через месяц");
		parseTest(str2Time, "через год");
		parseTest(str2Time, "через голову");

	}

	private static void parseTest(Str2Time str2Time, String timeString) {
		System.out.println(timeString + "\t->\t" + MyUtils.getFormattedDate( str2Time.convert(timeString) ) +"\t" + str2Time.getBefore() + " ... " + str2Time.getAfter());
	}

}
