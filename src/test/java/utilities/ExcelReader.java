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

public class ExcelReader {

    public static Object[][] readExcel(String sheetName) {
        List<Object[]> dataList = new ArrayList<>();

        String filePath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\Excel\\TestDataforScenarios.xlsx";

        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet " + sheetName + " not found.");
            }

            int colCount = sheet.getRow(0).getLastCellNum(); // From header row

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null || isRowEmpty(row)) continue;

                Object[] rowData = new Object[colCount];
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    rowData[j] = getCellValue(cell);
                }
                dataList.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("🧪 Total Valid Test Cases: " + dataList.size());
        return dataList.toArray(new Object[0][0]);
    }

    private static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell != null && cell.getCellType() != CellType.BLANK && !getCellValue(cell).toString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    double val = cell.getNumericCellValue();
                    return val == (long) val ? String.valueOf((long) val) : String.valueOf(val);
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
            case ERROR:
            default:
                return "";
        }
    }
    
    //read invalid code (testNG) 
    
    public List<Map<String, String>> readFromExcel(String filePath, String sheetName) throws IOException {
        // Open the file and create workbook
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
      
       // Get the specified sheet
       Sheet sheet = workbook.getSheet(sheetName);
               // Get the total number of rows (excluding the header row)
       int totalRow = sheet.getLastRowNum();  // This gives the index of the last row
      System.out.println("totalRow--->" + totalRow);

     // List to hold the rows of data
        List<Map<String, String>> excelRows = new ArrayList<>();

        // Iterate through each row (starting from the second row to skip the header)
        for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
            Row row = sheet.getRow(currentRow);
            if (row == null) continue;  // Skip empty rows

          // Get the total number of columns in the row
            int totalColumn = row.getLastCellNum();

          // Create a map to hold the row data (key-value pairs of column header and cell value)
          LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();

            // Iterate through each cell in the row
            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
               // Get the current cell
                Cell cell = row.getCell(currentColumn);

               // Get the column header from the first row (header row)
               String columnHeaderName = sheet.getRow(0).getCell(currentColumn).getStringCellValue(); // First row as header

                // Handle different cell types
               String data = "";
               if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            data = cell.getStringCellValue();
                           break;
                      case NUMERIC:
// Handle numeric cells
                         if (DateUtil.isCellDateFormatted(cell)) {
                            data = cell.getDateCellValue().toString();  // Date formatted cells
                          } else {
                              data = String.valueOf(cell.getNumericCellValue());  // General numeric cells
                            }
                            break;
                       case BLANK:
                           data = "";  // Blank cells
                           break;
                        default:
                            data = "";  // Default case for other cell types (like BOOLEAN, FORMULA, ERROR)
                    }
               }

                // Add the data to the map
                columnMapdata.put(columnHeaderName, data);
            }

           // Add the map (row data) to the list
           excelRows.add(columnMapdata);
       }

       // Close the file input stream and workbook
       workbook.close();
       fis.close();
       return excelRows;
    }
}