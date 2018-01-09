/**
 * MathConstant
 * Its a Constant class that defines the aliases of the Math factory
 * 
 * @author Anurup Borah
 */
package com.math.bodmas.constant;

public class MathConstant {
	public static final char DIVISON_SYMBOL = '/';
	public static final char MULTIPLY_SYMBOL = '*';
	public static final char ADD_SYMBOL = '+';
	public static final char SUBTRACT_SYMBOL = '-';
	
	public static final char OPEN_BRACKET_SYMBOL = '(';
	public static final char CLOSED_BRACKET_SYMBOL = ')';
	
	public static final String ALG_SQUAREROOT_SYMBOL = "sqrt";
	public static final String ALG_POWER_SYMBOL = "pow";
	public static final String ALG_GAUSS_SYMBOL = "gauss";
	
	public static final char[] OPERATOR_ARR = { DIVISON_SYMBOL, MULTIPLY_SYMBOL, ADD_SYMBOL, SUBTRACT_SYMBOL };
	public static final char[] BRACKETS = { OPEN_BRACKET_SYMBOL, CLOSED_BRACKET_SYMBOL };
	public static final String[] ALGEBRIC_FORMULAE = { ALG_SQUAREROOT_SYMBOL, ALG_POWER_SYMBOL , ALG_GAUSS_SYMBOL };
	
	public static final String REGEX_MATH_OPERATION = "[-+*/]";
	
	public static final char[] BODMAS_PRECEDENCE = {'/','*','+'};
}
