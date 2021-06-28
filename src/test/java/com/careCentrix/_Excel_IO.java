package com.careCentrix;



import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class _Excel_IO {

    @Test
    public void readExcelFile() {
        try(FileInputStream fileInputStream = new
                FileInputStream("Data1.xlsx")){


            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("Sheet1");
            Row row = sheet.getRow(0);
            Cell cell = row.getCell(0);
            System.out.println(cell);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void ReadCSV() throws Exception
    {
//parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("result.csv"));
         sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(sc.next() + " ");  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner
    }
}






