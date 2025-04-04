package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader1 {

	public static int totalRow;


	public static String getCodeFromExcel(String filePath, String sheetName, int rowNum, int cellNum)
			throws IOException {
		
		FileInputStream fis = new FileInputStream(new File(filePath));

		
		Workbook workbook = new XSSFWorkbook(fis);

		
		Sheet sheet = workbook.getSheet(sheetName);

		
		Row row = sheet.getRow(rowNum);

		
		Cell cell = row.getCell(cellNum);

		
		String code = cell.getStringCellValue();

		
		workbook.close();
		fis.close();

		return code;
	}

	
	public List<Map<String, String>> readFromExcel(String filePath, String sheetName)
			throws IOException {
		
		FileInputStream fis = new FileInputStream(new File(filePath));

		
		Workbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row;
		Cell cell;
		totalRow = sheet.getLastRowNum();
		System.out.println("totalRow--->" + totalRow);

		List<Map<String, String>> excelRows = new ArrayList<>();

		for (int currentRow = 1; currentRow <= totalRow; currentRow++) { 
			row = sheet.getRow(currentRow);
			int totalColumn = row.getLastCellNum();
			
			LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();

			String data = null;

			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) { 
																						
				cell = row.getCell(currentColumn);

				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue(); 
				

				if (cell != null) {
					if (cell.getCellType() == CellType.STRING) {
						data = cell.getStringCellValue();
					} else if (cell.getCellType() == CellType.NUMERIC) {
						data = String.valueOf(cell.getNumericCellValue());
					} else if (cell.getCellType() == CellType.BLANK) {
						data = String.valueOf(cell.getStringCellValue());
					}
				} else {
					data = "";

				}
				columnMapdata.put(columnHeaderName, data);
			}

			excelRows.add(columnMapdata);
		}

		return excelRows;

	}
}