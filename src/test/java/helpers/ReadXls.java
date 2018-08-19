package helpers;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ReadXls {
    public List<String[]> readXls() {
        List<String[]> listTestsParams = new LinkedList(); //список с тестовыми параметрами

        try {
            File file = new File("in.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheet("Лист1");
            XSSFRow row;
            int last_row = sheet.getLastRowNum();
            for (int i = 1; i < last_row + 1; i++) {
                String param[] = new String[5]; //параметры одной строки в excell
                row = sheet.getRow(i);
                XSSFCell cell1 = row.getCell(0);
                XSSFCell cell2 = row.getCell(1);
                XSSFCell cell3 = row.getCell(2);
                XSSFCell cell4 = row.getCell(3);
                XSSFCell cell5 = row.getCell(4);

                String cell1_value = cell1.getStringCellValue();
                String cell2_value = cell2.getStringCellValue();
                double cell3_value = cell3.getNumericCellValue();
                double cell4_value = cell4.getNumericCellValue();
                String cell5_value = cell5.getStringCellValue();

                param[0] = cell1_value;
                param[1] = cell2_value;
                param[2] = String.valueOf((int) cell3_value);
                param[3] = String.valueOf((int) cell4_value);
                param[4] = cell5_value;

                listTestsParams.add(param);
            }
        } catch (Exception e) {
            System.out.println("Ошибка:  " + e);
        }

        return listTestsParams;
    }
}

