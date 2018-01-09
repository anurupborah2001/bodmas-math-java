/**
 * NullMath
 * --This class gives the null valus if the Factory class does not match
 * 
 * Null Pattern
 * 
 * @author Anurup Borah
 */
package com.math.bodmas.implementation;

import com.math.bodmas.base.AbstractMath;
import com.math.bodmas.interfaces.IGeneralMath;

public class NullMath extends AbstractMath implements IGeneralMath{

	@Override
	public Double add(Double x, Double y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double subtract(Double x, Double y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double multiplication(Double x, Double multiplyBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double division(Double x, Double divideBy) {
		// TODO Auto-generated method stub
		return null;
	}

}
