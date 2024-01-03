package com.kraft.tests.day19_DDF;

import com.kraft.utilities.ConfigurationReader;
import com.kraft.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class _2_ExcelUtilDemo {

    @Test
    public void  readExcelFile(){
        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */

        //satır sayısı
        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/LoginList.xlsx","Test");
        System.out.println("excelUtil.rowCount() = " + excelUtil.rowCount());
    }

    @Test
    public void  readExcelFile_2(){
        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */

        ExcelUtil excelUtil=new ExcelUtil(ConfigurationReader.get("excelPath"),"Test");

        //sütun sayısı
        System.out.println("excelUtil.columnCount() = " + excelUtil.columnCount());

        //sütun isimlerini alalım
        List<String> columnsNames = excelUtil.getColumnsNames();
        System.out.println("columnsNames = " + columnsNames);

        //bütün datayı çok boyutlu arraye alalım
        String[][] dataArray = excelUtil.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));

        for (String[] dataRow : dataArray) {
            for (String cell : dataRow) {
                System.out.print(cell+ " ");
            }
            System.out.println();
        }

        //belirli bir dataya satır ve sütun bilgisiyle ulaşabilirim
        System.out.println("dataArray[3][2] = " + dataArray[3][2]);

        List<Map<String, String>> dataList = excelUtil.getDataList();

        System.out.println("dataList = " + dataList);

        System.out.println("dataList.get(3).get(\"First Name\") = " + dataList.get(3).get("First Name"));

    }

}
