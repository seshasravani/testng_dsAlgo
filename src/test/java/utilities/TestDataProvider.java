package utilities;

import org.testng.annotations.DataProvider;



public class TestDataProvider {


	@DataProvider(name = "RegisterPageData1")
	public Object[][] getRegisterData() {
		return ExcelReader.readExcel("register");
	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
	    return ExcelReader.readExcel("Login"); 
	}

	@DataProvider(name = "codeExecutionDataInvalid")
	public Object[][] getTryHereCodeDataInvalid() {
		return ExcelReader.readExcel("editor-invalid");
	}
	
	@DataProvider(name = "codeExecutionDataValid")
	public Object[][] getTryHereCodeDataValid() {
		return ExcelReader.readExcel("editor-valid");
	}
		
}
