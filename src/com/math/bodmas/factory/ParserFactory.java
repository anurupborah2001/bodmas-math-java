/**
 * ParserFactory
 * -- this class provide the factory for the Parser classes
 * 
 * 
 * @author Anurup Borah
 */
package com.math.bodmas.factory;

import com.math.bodmas.base.AbstractFactory;
import com.math.bodmas.base.AbstractParser;
import com.math.bodmas.implementation.MainParser;
import com.math.bodmas.implementation.StringParser;

public class ParserFactory extends AbstractFactory{

	public ParserFactory(AbstractParser parser){
		this.makeParser(parser);
	}
	
	public AbstractParser makeParser(AbstractParser parser) {
		// TODO Auto-generated method stub
		if(parser instanceof MainParser){
			return new MainParser();
		} 
		if(parser instanceof StringParser){
			return new StringParser();
		}
		return null;
	}
		
}
