/**
 * MathFactory
 * Its Factory class producing the objects for the Mathematic class
 * 
 * Factory Pattern 
 * 
 * @author Anurup Borah
 */
package com.math.bodmas.factory;

import com.math.bodmas.base.AbstractFactory;
import com.math.bodmas.base.AbstractMath;
import com.math.bodmas.constant.FactoryConstant;
import com.math.bodmas.implementation.AlgebricMath;
import com.math.bodmas.implementation.GeneralMath;
import com.math.bodmas.implementation.NullMath;


public class MathFactory extends AbstractFactory{
	

	public AbstractMath makeMath(String strObj) {
		// TODO Auto-generated method stub
		if(strObj==FactoryConstant.ALGEBRIC_MATH_OBJ){
			return new AlgebricMath();
		} 
		if(strObj==FactoryConstant.GENERAL_MATH_OBJ){
			return new GeneralMath();
		}
		return new NullMath();
	}

}
