package org.example.constant;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;

public class ConstantData {
   public static String excepath="src\\main\\java\\org\\example\\exceldata\\excelsheet2.xls";
   public static String sheenName="Sheet1";

   public static FileOutputStream foutstream;
   public static HSSFWorkbook workbook;

   public static String month="April";
   public static int date=30;
   public static HSSFSheet sheet;
}
