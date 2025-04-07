package dstestcases;

import org.testng.annotations.Test;

import utilities.LoggerLoad;

public class LoggerTest {
	
	@Test
	public void test01_TestingLog() throws InterruptedException 
	
	{
		//if you want to display info message
		LoggerLoad.info("<-------------Testing Info------------->");
		
		//if you want to display warn message
		LoggerLoad.warn("<-------------Testing Info------------->");
		
		
		//if you want to display error message
				LoggerLoad.warn("<-------------Testing error------------->");
				}
	}
	
	
