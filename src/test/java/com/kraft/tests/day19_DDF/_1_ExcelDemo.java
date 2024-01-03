package com.kraft.tests.day19_DDF;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _1_ExcelDemo {

    String readFromExcelCell(String path, String sheetName, int row, int column) throws IOException {
        FileInputStream fis=new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);
        String cellValue = sheet.getRow(row).getCell(column).getStringCellValue();
        return cellValue;
    }

    @Test
    public void test1() throws IOException {
        String cellValue = readFromExcelCell("src/test/resources/LoginList.xlsx", "Test", 3, 2);

        System.out.println("cellValue = " + cellValue);
    }
}
