package com.orangehrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.Columns;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.orangehrm.base.BasePage;

public class XLSReader extends BasePage{


    private Workbook workbook;

    public XLSReader(String excelFilePath) {
        FileInputStream fis;
		try {
			fis = new FileInputStream(new File(excelFilePath));
			 workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }

    public String getCellDataExcel(int sheetNumber, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheetAt(sheetNumber);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    public int rowCount(int sheetNumber) {
        Sheet sheet = workbook.getSheetAt(sheetNumber);
        return sheet.getPhysicalNumberOfRows() + 1;
    }

    public int columnCount(int sheetNumber) {
        Sheet sheet = workbook.getSheetAt(sheetNumber);
        Row row = sheet.getRow(0);
        return row.getLastCellNum();
    }
		
	public String sheetName(int sheetNumber) {
		Sheet sheet = workbook.getSheetAt(sheetNumber);
		String sname = sheet.getSheetName();
		
		return sname;
	}
	
	
	public List<ArrayList<String>> getDataTestng(int sheetnumber) throws IOException{
		List<ArrayList<String>> data = new ArrayList<>();
	    Sheet sheet = workbook.getSheetAt(sheetnumber);
	    int totalRows = sheet.getLastRowNum();
		System.out.println("Total no. of Rows is" +totalRows );
		System.out.println("Total no. of Columns is" +totalRows );
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) { // Ensure loop includes last row
	        Row row = sheet.getRow(rowIndex);
	        System.out.println("Total no. of Columns is" +row.getLastCellNum() );
	        if (row != null) {
	            ArrayList<String> rowData = new ArrayList<>();
	            int totalCols = row.getLastCellNum();
	            
	            for (int cellIndex = 1; cellIndex < totalCols; cellIndex++) { // Start from 0 to include all columns
	                Cell cell = row.getCell(cellIndex);
	                if (cell != null) {
	                    rowData.add(getCellValue(cell));
	                } 
	            }
	            data.add(rowData);
	        }
	    }
	    return data;
		
	}
	
	
	
	
	private static String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
		
}
