package dstestcases;

import org.testng.annotations.Test;

import utilities.LoggerLoad;

public class LoggerTest {

	@Test
	public void test01_TestingLog() throws InterruptedException

	{

		LoggerLoad.info("<-------------Testing Info------------->");

		LoggerLoad.warn("<-------------Testing Info------------->");

		LoggerLoad.warn("<-------------Testing error------------->");
	}
}
