package com.orangehrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    public String getCellData(int sheetNumber, int rowNum, int colNum) {
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
        return sheet.getLastRowNum() + 1;
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
		
}
