package org.example.excelsheets;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.example.constant.ConstantData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.*;

public class ReadWriteExcel
{
    public static void writeTOExcel(String sheetName,int row,int cell,String data) throws IOException
    {
         creatSheet("Sheet1");
        if (ConstantData.sheet.getRow(row)==null)
        {
            ConstantData.sheet.createRow(row).createCell(cell).setCellValue(data);
        }else {
            ConstantData.sheet.getRow(row).createCell(cell).setCellValue(data);
        }
         setcloseFilePath(row,cell,sheetName);
     }

      public static void creatSheet(String sheetName)
      {
          if(ConstantData.workbook == null){
          ConstantData.workbook=new HSSFWorkbook();
          ConstantData.sheet=ConstantData.workbook.createSheet(sheetName);}
      }
     public static void setcloseFilePath(int row,int cell,String sheetName)
     {
         try {
             ConstantData.foutstream = new FileOutputStream(new File(ConstantData.excepath));
           ConstantData.workbook.write(ConstantData.foutstream);
             ConstantData.foutstream.close();
             ConstantData.workbook.close();
         }catch (Exception e)
         {
             e.getMessage();
         }
     }
     public static Cell readToExcel(String SheetName,int row,int cell) throws IOException {
         FileInputStream file=new FileInputStream(new File(ConstantData.excepath));

         Cell cell1= WorkbookFactory.create(file).getSheet(SheetName).getRow(row).getCell(cell);


         return cell1;
     }
}
