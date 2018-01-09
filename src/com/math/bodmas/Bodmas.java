/** Currently only supports sqrt , pow , gauss for algebric function 
 * 
 * @author Anurup Borah
 *
 * References
 * ---------------------
s * https://introcs.cs.princeton.edu/java/22library/Gaussian.java.html//References
 * 
 * Sample Example :
 * 
 * 3+5*7/2*sqrt(2)
 * 100*pow(2,3)*3
 * 3-9*3+900*sqrt(5)/pow(2,3)
 * 
 */
package com.math.bodmas;

import java.util.Scanner;

import com.math.bodmas.implementation.MathEvalOperation;


public class Bodmas{
   public static void main(String[] args) {
	   	@SuppressWarnings("resource")
		Scanner scanLine = new Scanner(System.in);
	   	Double resultCalculation = 0.0;
    	System.out.println("Enter your Calculation: ");
    	String computationStr = scanLine.nextLine();
    	if(!computationStr.isEmpty()){
    		MathEvalOperation mathOps = new MathEvalOperation(computationStr);
    		resultCalculation = mathOps.compute();  
    		System.out.println(resultCalculation);
    	}
	}
}
