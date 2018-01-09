/**
 * MathClassAccessHelper
 * --This class is a helper class and provides the Reflection Object of the classes
 * 
 * @author Anurup Borah
 */
package com.math.bodmas.helper;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.math.bodmas.base.AbstractFactory;
import com.math.bodmas.base.AbstractMath;

public class MathClassAccessHelper {
    
	AbstractMath className = null;
	Method[] methods = null;
	List<String> result = new ArrayList<String>();
	
	public MathClassAccessHelper(AbstractMath className){
		this.className = className;
		initClass();
	}
	
	public void initClass(){
		Class tClass = this.className.getClass();
		methods = tClass.getDeclaredMethods();
	}
	
	public List<String> getMethodName(){
		for (Method method : methods) {
			result.add(method.getName());
	    }
		return result;
	}
	
	
	public int getMethodParameterCount(String methodName){
		int i = 0;
		for (Method declaredMethod : methods) {
			if (declaredMethod.getName().equals(methodName)) {
				i = declaredMethod.getParameterCount();
                break;
            }
		}
		return i;
	}
	
	@SuppressWarnings("rawtypes")
	public Method[] getAccessibleMethods() {
		List<Method> result = new ArrayList<Method>();
		Class tClass = this.className.getClass();
	    while (this.className != null) {
	        for (Method method : tClass.getDeclaredMethods()) {
	        	 result.add(method);
	        }
	        tClass = tClass.getSuperclass();
	    }
	    return result.toArray(new Method[result.size()]);
	}
}
