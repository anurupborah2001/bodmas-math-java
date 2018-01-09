/**
 * StringParser
 * --This class is used for doing any string manipulation  
 * 
 * --Singleton Pattern is implemented - only one static variable will be created in the permanent memory location
 * @author Anurup Borah
 */
package com.math.bodmas.implementation;


public class StringParser extends MainParser{
	
	private static StringParser instance;
	
	public static synchronized StringParser getInstance() {
	    if (instance == null) {
	    	StringParser.instance = new StringParser();
	    }

	    return instance;
	  }
	
	public char[] convertStringtoArray(String strExp){
		return strExp.toCharArray();
	}
	
	public String[] splitStringByRegex(String strExp,String regEx) {
		String[] result = strExp.split(regEx);
		return result;
	}

}
