package com.eurotech.tests.day_23_DDF;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class _2_ExcelUtilDemo {

    @Test
    public void readExcelFile(){
        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */

        ExcelUtil excelData=new ExcelUtil("src/test/resources/LoginList.xlsx","Test");

        System.out.println("excelData.rowCount() = " + excelData.rowCount());

    }
    @Test
    public void readExcelFile_2(){
        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */

        ExcelUtil excelData=new ExcelUtil(ConfigurationReader.get("excelPath"),"Test");

        //get column count
        System.out.println("excelData.columnCount() = " + excelData.columnCount());
        System.out.println("________________________");

        //get column names
        System.out.println("excelData.getColumnsNames() = " + excelData.getColumnsNames());
        System.out.println("________________________");

        String[][] dataArray = excelData.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));
        System.out.println("________________________");

        System.out.println("dataArray[3][2] = " + dataArray[3][2]);
        System.out.println("________________________");

        String[][] dataArrayWithoutFirstRow = excelData.getDataArrayWithoutFirstRow();
        System.out.println("Arrays.deepToString(dataArrayWithoutFirstRow) = " + Arrays.deepToString(dataArrayWithoutFirstRow));

        System.out.println("dataArrayWithoutFirstRow[3][2] = " + dataArrayWithoutFirstRow[3][2]);
        System.out.println("________________________");

        List<Map<String,String>>dataList= excelData.getDataList();
        System.out.println("dataList = " + dataList);
        System.out.println("________________________");

        System.out.println("dataList(0) = " + dataList.get(0));
        System.out.println("________________________");

        System.out.println("dataList.get(4).get(\"Company\") = " + dataList.get(4).get("Company"));
        System.out.println("________________________");
        System.out.println("dataList.get(9).get(\"City\") = " + dataList.get(9).get("City"));


    }

}
