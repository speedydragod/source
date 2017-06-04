package com.model.ChainOfResponsibilityPattern;

public class TestChainPattern {

	public static AbstractLogger getChainOfLoggers(){
		
		AbstractLogger error=new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger file=new FileLogger(AbstractLogger.INFO);
		AbstractLogger console=new ConsoleLogger(AbstractLogger.DEBUG);
		
		error.setNextLogger(file);
		file.setNextLogger(console);
		
		return error;
	}
	
	public static void main(String[] args) {
		
		AbstractLogger logger=getChainOfLoggers();
		
		logger.logMessage(AbstractLogger.DEBUG, "this is a debug messgae");
		logger.logMessage(AbstractLogger.INFO, "this is a info messgae");
		logger.logMessage(AbstractLogger.ERROR, "this is a error messgae");
		
	}
}
