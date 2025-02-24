package org.example.tests.DataDriven;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {

    static Workbook book;
    static Sheet sheet;

    public static String FILE_NAME = "src/main/resources/TestSheet1.xlsx";


    public static Object[][] getTestData(String SheetName) throws IOException {
        FileInputStream file = null;
        file = new FileInputStream(FILE_NAME);
        book = WorkbookFactory.create(file);
        sheet = book.getSheet(SheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

            }
        }
        return data;
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return getTestData("Sheet1");
    }

}


