package utilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class TestDataProvider {
	
	private static final String EXCEL_PATH = "src/test/resources/Excel/TestData.xlsx";
	ExcelReader excelReader = new ExcelReader();
	
	
	// ********** LOGIN FEATURE DATA PROVIDER **********
	
	@DataProvider(name = "alertMessagesForEmptyFields")
	public Object[][] getAlertMessagesForEmptyFields() {
		return new Object[][] { { "Please fill out this field." } };
	}
	
	
		// ********** GENERIC METHOD TO READ EXCEL DATA **********
	public void enterLoginFormFields(String sheetname, int row)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		LoggerLoad.info("Inside enterLoginFormFields");

		List<Map<String, String>> testdata = excelReader.readFromExcel("src/test/resources/Excel/TestData.xlsx", sheetname);
		LoggerLoad.info("logintestdata");
	
		
		String username = testdata.get(row).get("username");
		enterUsernameTxt(username);
		LoggerLoad.info("Fetched username from Excel: " + username);
		
		String password = testdata.get(row).get("password");
		LoggerLoad.info("Fetched password from Excel: " + password);
		enterPasswordTxt(password);
	}	
	}



