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
       
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
      
   
       Sheet sheet = workbook.getSheet(sheetName);
          
       int totalRow = sheet.getLastRowNum();  
      System.out.println("totalRow--->" + totalRow);


        List<Map<String, String>> excelRows = new ArrayList<>();

        
        for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
            Row row = sheet.getRow(currentRow);
            if (row == null) continue; 

         
            int totalColumn = row.getLastCellNum();

          
          LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();

            
            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
              
                Cell cell = row.getCell(currentColumn);

            
               String columnHeaderName = sheet.getRow(0).getCell(currentColumn).getStringCellValue(); // First row as header

              
               String data = "";
               if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            data = cell.getStringCellValue();
                           break;
                      case NUMERIC:

                         if (DateUtil.isCellDateFormatted(cell)) {
                            data = cell.getDateCellValue().toString();  
                          } else {
                              data = String.valueOf(cell.getNumericCellValue()); 
                            }
                            break;
                       case BLANK:
                           data = ""; 
                           break;
                        default:
                            data = ""; 
                    }
               }

           
                columnMapdata.put(columnHeaderName, data);
            }

          
           excelRows.add(columnMapdata);
       }

       workbook.close();
       fis.close();
       return excelRows;
    }
}