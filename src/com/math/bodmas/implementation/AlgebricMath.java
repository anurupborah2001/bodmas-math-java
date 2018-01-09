/**
 * AlgebricMath
 * -- this class provides all the algebric function
 * if in future any more classes added can be implemented here
 * all other Maths functionality can be implemented here
 * 
 * @author Anurup Borah
 */
package com.math.bodmas.implementation;

import com.math.bodmas.base.AbstractMath;
import com.math.bodmas.interfaces.IAlgebricMath;
import com.math.bodmas.interfaces.IGeneralMath;
import com.math.bodmas.mathlogic.Gaussian;

public class AlgebricMath extends AbstractMath implements IAlgebricMath{
	public Gaussian gaussian;
	
	public Double sqrt(Double x) {
		if (x < 0) 
			return (double) -1; 
		if (x == 0 || x == 1)
			return x; 
		float start = 0.0f; 
		float end =  new Float(x); 
		float precision = 0.001f; 
		float middle = start; 
		float difference = (float) Math.abs(Math.pow(middle, 2) - x);
		while (difference >= precision) { 
			middle = (start + end) / 2.0f; 
			if (Math.pow(middle, 2) > x) { 
				end = middle; 
				} else { 
					start = middle; 
				} 
			difference = (float) Math.abs(Math.pow(middle, 2) - x); 
			} 
		return (double)middle;
//			return Math.sqrt(x);
	}

	public Double pow(Double x, Double power) {
		return Math.pow(x, power);
	}

	@Override
	public Double gaussian(Double z, Double mu, Double sigma) {
		return this.gaussian(z, mu, sigma);
	}

}
