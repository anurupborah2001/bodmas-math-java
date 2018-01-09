/**
 * GeneralMath
 * --This class provides the basic Arithmetic Operation i.e add, divide, subtract and multiplication
 * 
 * @author Anurup Borah
 */
package com.math.bodmas.implementation;

import com.math.bodmas.base.AbstractMath;
import com.math.bodmas.interfaces.IGeneralMath;

public class GeneralMath extends AbstractMath implements IGeneralMath{

	@Override
	public Double add(Double x, Double y) {
		try{
			return x+y;
		}catch (ArithmeticException e) {
			return 0.0;
		}
	}

	@Override
	public Double subtract(Double x, Double y) {
		// TODO Auto-generated method stub
		try{
				return x-y;
		}catch (ArithmeticException e) {
			return 0.0;
		}
	}

	@Override
	public Double multiplication(Double x, Double multiplyBy) {
		// TODO Auto-generated method stub
		try{
			return x*multiplyBy;
		}catch (ArithmeticException e) {
			return 0.0;
		}
		
	}

	@Override
	public Double division(Double x, Double divideBy) {
		// TODO Auto-generated method stub
		try{
			return x/divideBy;
		}catch (ArithmeticException e) {
			throw new
            UnsupportedOperationException("Cannot divide by zero");
		}
	}

}
