/***
 *   Copyleft 2014 - WareNinja.com / Rumble In The Jungle!
 * 
 *  @author: yg@wareninja.com
 *  @see https://github.com/WareNinja
 *  disclaimer: I code for fun, dunno what I'm coding about :-)
 */

package com.wareninja.opensource.strtotime.matcher;

import java.util.Calendar;


public abstract class Matcher {

	/**
	 * @param input
	 * @param refDate
	 * 
	 * @return the converted Date
	 */
	public abstract Boolean tryConvert(String input, Calendar refDate);

	protected String stringWithoutMatch = null;

	public String getStringWithoutMatch() {
		return stringWithoutMatch;
	}
}