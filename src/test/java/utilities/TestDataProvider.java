package utilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	    private static final String EXCEL_PATH = "src/test/resources/Excel/TestData.xlsx";
	    static ExcelReader excelReader = new ExcelReader();

	
	    @DataProvider(name = "validCodeForTraversal")
	    public Object[][] getValidCodeForTraversal() throws IOException {
	        List<Map<String, String>> testData = excelReader.readFromExcel(EXCEL_PATH, "tryEditorCode");
	        Object[][] data = new Object[testData.size()][1];  // 1 column for code

	        for (int i = 0; i < testData.size(); i++) {
	            data[i][0] = testData.get(i).get("validCode"); // Fetching code from Excel
	        }
	        return data;
	    }
	}