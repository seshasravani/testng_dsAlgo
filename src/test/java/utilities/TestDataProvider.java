package utilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	//private static final String EXCEL_PATH = "src/test/resources/Excel/TestData.xlsx";
	ExcelReader excelReader = new ExcelReader();
	
	@DataProvider(name = "invalidCodeData")
	public Object[][] getInvalidCodeData() throws InvalidFormatException, IOException {
		System.out.println("Inside getInvalidCodeData() method");
	    List<Map<String, String>> testData = excelReader.readFromExcel("src/test/resources/Excel/TestData.xlsx", "tryEditorCode");
	    
	    Object[][] data = new Object[testData.size()][1]; // Only one column (pCode)

	    for (int i = 0; i < testData.size(); i++) {
	        data[i][0] = testData.get(i).get("pCode"); // Fetch code from "pCode" column
	    }

	    return data;
	}
}