/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@wareninja.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */


import com.wareninja.opensource.strtotime.MyUtils;
import com.wareninja.opensource.strtotime.Str2Time;

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


		System.out.println("NOW -> " + MyUtils.getFormattedDate( Str2Time.convert("NOW") ));
		System.out.println("now -1 day -> " + MyUtils.getFormattedDate( Str2Time.convert("now -1 day") ));

		System.out.println("tomorrow -> " + MyUtils.getFormattedDate( Str2Time.convert("tomorrow") ));
		System.out.println("yesterday -> " + MyUtils.getFormattedDate( Str2Time.convert("yesterday") ));
		System.out.println("+80 minutes -> " + MyUtils.getFormattedDate( Str2Time.convert("80 minutes") ));
		System.out.println("-160 minutes -> " + MyUtils.getFormattedDate( Str2Time.convert("-160 minutes") ));
		System.out.println("+8 days -> " + MyUtils.getFormattedDate( Str2Time.convert("8 days") ));
		System.out.println("-16 days -> " + MyUtils.getFormattedDate( Str2Time.convert("-16 days") ));
		System.out.println("+2 weeks -> " + MyUtils.getFormattedDate( Str2Time.convert("2 weeks") ));
		System.out.println("-4 weeks -> " + MyUtils.getFormattedDate( Str2Time.convert("-4 weeks") ));
		System.out.println("Mon Sep 24 03:35:21 +0000 2012 -> " + MyUtils.getFormattedDate( Str2Time.convert("Mon Sep 24 03:35:21 +0000 2012") )); // @todo fixme

		parseTest("2015-03-12 23:50:59");
		parseTest("2015-3-12 23:49");
		parseTest("2015-03-12");
		parseTest("20150312");
		parseTest("20150312 +2 DAY");
		parseTest("2015-03-12 11 45");
		parseTest("today 10:30");
		parseTest("tomorrow at 11:45:00");
		parseTest("yesterday at 11:45");
		parseTest("today at 11 45");
	}

	private static void parseTest(String timeString) {
		System.out.println(timeString + " -> " + MyUtils.getFormattedDate( Str2Time.convert(timeString) ));
	}

}
