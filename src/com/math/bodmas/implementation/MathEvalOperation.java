/**
 * MathEvalOperation
 * --This class performs the maion functionality of the Bodmas Application
 * 
 * 
 * Strategy Pattern are used here
 * Composite Pattern
 * 
 * @author Anurup Borah
 */
package com.math.bodmas.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.math.bodmas.constant.FactoryConstant;
import com.math.bodmas.constant.MathConstant;
import com.math.bodmas.factory.MathFactory;
import com.math.bodmas.helper.MathClassAccessHelper;
import com.math.bodmas.interfaces.IAlgebricMath;
import com.math.bodmas.interfaces.IGeneralMath;

public class MathEvalOperation {
	String inputStr = "";
	static ArrayList<Integer> indexOfStr = new ArrayList<Integer>();
	static ArrayList<String> algebricFunc = new ArrayList<String>();
	
	static IGeneralMath generalMath = null;
	static IAlgebricMath algebricMath = null;
	char bodmas[] = MathConstant.BODMAS_PRECEDENCE;
	
	Stack<Integer> ops  = new Stack<Integer>();
	Stack<Double>  intVal = new Stack<Double>();
   
    Stack<Integer> opstemp  = new Stack<Integer>();
    Stack<Double> intValtemp = new Stack<Double>();
    
    MathClassAccessHelper classMthods;
	
	public MathEvalOperation(String inputStr){
		this.inputStr = inputStr;
		MathFactory  mathFactory = new MathFactory();
		generalMath = (IGeneralMath) mathFactory.makeMath(FactoryConstant.GENERAL_MATH_OBJ);
		algebricMath = (IAlgebricMath) mathFactory.makeMath(FactoryConstant.ALGEBRIC_MATH_OBJ);
	}
	
	public Double compute(){
		String inputStrNew = calculateAlgebricExpression(this.inputStr);
		return this.evaluateCalculation(inputStrNew);
	}
	
	public String calculateAlgebricExpression(String tokenStr){
		String modifiedStr = tokenStr;
		if (containsStrings(tokenStr))
        { 
			int a = 0,b = 0,c = 0;
			
			for (int i = 0; i < indexOfStr.size(); i++) {
				int getIndex = algebricFunc.get(i).length();
				int getTotalIndex = getIndex + indexOfStr.get(i);
				String subStr = tokenStr.substring(getTotalIndex,tokenStr.length());
				String getNumbers = subStr.substring(subStr.indexOf("(")+1,subStr.indexOf(")"));
				String[] numberSplit= getNumbers.split(",");
				int parametercount = classMthods.getMethodParameterCount(algebricFunc.get(i));
				if(parametercount != numberSplit.length){
					System.err.println("The parameters for the algebric function '" + algebricFunc.get(i) + "' is wrong" );
					break;
				}
				
				int[] listInt = toIntArray(getNumbers,",");
				if(listInt!= null){
					try {
						a = listInt[0];
						b = listInt[1];
						c = listInt[2];
					}catch(ArrayIndexOutOfBoundsException e){
						//System.out.println("Error " + e.getMessage());
						int idx = Integer.parseInt(e.getMessage());
						if(idx==0){ a = 0; }
						if(idx==1){ b = 0; }
						if(idx==2){ c = 0; }
					}
					double getAlgebric = calculateAlgebricOperation(algebricFunc.get(i),a,b,c);
					String algReplace = algebricFunc.get(i) + "(" + getNumbers  + ")";
					modifiedStr = modifiedStr.replace(algReplace,getAlgebric + "");
				}
				
			}
        }
		return modifiedStr;
	}
	
	public Double evaluateCalculation(String tokenString){
		String newtokenString = tokenString.replaceAll("-","+-");
		storeInStack(newtokenString);
		if(!intVal.isEmpty()){
			for (int i = 0; i < bodmas.length; i++)
	        {
			    boolean it = false;
	            while (!ops.isEmpty())
	            {
	                int optr = ops.pop();
	                double v1 = intVal.pop();
	                double v2 = intVal.pop();
	                double v3 = 0.0;
	                if (optr == bodmas[i])
	                {
	                	v3 = calculateMathOperation(bodmas[i],v1,v2);
	                	intValtemp.push(v3);
	                    it = true;
	                    break;                                        
	                }
	                else
	                {
	                	intValtemp.push(v1);
	                    intVal.push(v2);
	                    opstemp.push(optr);
	                }                
	            }
	            
	                  
	            while (!intValtemp.isEmpty())
	            	intVal.push(intValtemp.pop());
	            while (!opstemp.isEmpty())
	                ops.push(opstemp.pop());
	          
	            if (it)
	                i--;                            
	        }
	        return intVal.pop();
		}
		return 0.0;
	}
	
	public void storeInStack(String newTokenStr){
	    String temp = "";
	    try{
		        for (int i = 0;i < newTokenStr.length();i++)
		        {
		            char ch = newTokenStr.charAt(i);
		           
			            if (ch == '-'){
			                temp = "-" + temp;
			            }else if (ch != '+' &&  ch != '*' && ch != '/'){
			            	/* insertion of only numbers*/
			            	temp = temp + ch;
			            }else {
			            	/* insertion when character is operator {'/','*','+'} */
			            	intVal.push(Double.parseDouble(temp));
			            	/* save operator as ASCII value except '-' operator  which is low precedence and can be attached to digits*/
			            	ops.push((int)ch);
			                temp = "";
			            }
		            
		        }
		        intVal.push(Double.parseDouble(temp));
	    }catch(Exception e){
	    	intVal.removeAllElements();
        	System.err.println("Please enter a valid calculation format");
        }
	}
	
	public static Double calculateAlgebricOperation(String operator, double a, double b, double c)
    {
		switch (operator)
        {
        		case MathConstant.ALG_SQUAREROOT_SYMBOL:
        			return algebricMath.sqrt(a);
        		case MathConstant.ALG_POWER_SYMBOL:
        			return algebricMath.pow(a,b);
        		case MathConstant.ALG_GAUSS_SYMBOL:
        			return algebricMath.gaussian(a,b,c);
        }
		return 0.0;
		
    }
	
	public static Double calculateMathOperation(char operator, double a, double b)
    {
		switch (operator)
        {
	        case MathConstant.ADD_SYMBOL:
	            return generalMath.add(a,b);
	        case MathConstant.SUBTRACT_SYMBOL:
	            return generalMath.subtract(a,b);
	        case MathConstant.MULTIPLY_SYMBOL:
	            return generalMath.multiplication(a,b);
	        case MathConstant.DIVISON_SYMBOL:
	            if (a == 0)
	                throw new
	                UnsupportedOperationException("Cannot divide by zero");
	            return b / a;
        }
        return 0.0;
    }
	
	public boolean containsStrings(String tokenString) {
		classMthods = new MathClassAccessHelper(new AlgebricMath());
		List<String> methodName = classMthods.getMethodName();
		boolean stringExist = false;
        for (String x : methodName) {
            if ((tokenString.toLowerCase().indexOf(x.toLowerCase()) != -1)) {
            	indexOfStr.add(tokenString.toLowerCase().indexOf(x.toLowerCase()));
            	algebricFunc.add(x);
            	stringExist =  true;
            }
        }
        return stringExist;
    }
	
	
	public static int[] toIntArray(String input, String delimiter) {
		try {
			return  Arrays.stream(input.split(delimiter))
		                 .mapToInt(Integer::parseInt)
		                 .toArray();
		}catch(Exception e){
			return null;
		}
	}
	
	
	public static boolean containsCharacters(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }
	
	public static boolean bodmas(char operation1, char operation2)
    {
    	if (containsCharacters(operation1,MathConstant.BRACKETS))
            return false;
        if (containsCharacters(operation1,MathConstant.OPERATOR_ARR))
            return false;
        else
            return true;
    }	
}
