package utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {


		@DataProvider(name = "RegisterPageData1")
		public Object[][] getRegisterData() {
			return ExcelReader.readExcel("register");
		}
		 
			
		@DataProvider(name = "loginData")
		public Object[][] loginData() {
		    return ExcelReader.readExcel("Login"); // Make sure the sheet name is correct
		}

		@DataProvider(name = "codeExecutionDataInvalid")
		public Object[][] getTryHereCodeDataInvalid() {
			return ExcelReader.readExcel("editor-invalid");
		}
		
		@DataProvider(name = "codeExecutionDataValid")
		public Object[][] getTryHereCodeDataValid() {
			return ExcelReader.readExcel("editor-valid");
		}
		
	
	
	 /*   private static final String EXCEL_PATH = "src/test/resources/Excel/TestData.xlsx";
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
	    */
	}