package helpers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;

public class WriteResults {
    public void writeResults(int photoes_count, int row_index, String[] test_params) {


        try {
            InputStream file = new FileInputStream("out.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheet("Лист1");

            XSSFRow row = sheet.createRow(row_index);
            Cell cell_results = row.createCell(1);
            Cell cell_parametrs = row.createCell(0);

            cell_results.setCellValue("Найдено " + photoes_count + "  объектов с фото");
            cell_parametrs.setCellValue(Arrays.toString(test_params));
            FileOutputStream fileOut = new FileOutputStream("out.xlsx");
            wb.write(fileOut);
            fileOut.close();


        } catch (Exception e) {
            System.out.println("Ошибка +  " + e);
        }
    }
}
