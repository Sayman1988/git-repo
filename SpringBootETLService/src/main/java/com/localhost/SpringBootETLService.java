package com.localhost;

import com.localhost.etl.Extractor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by o.serohin on 11.07.2017.
 */
@Slf4j
@Component
public class SpringBootETLService {
    @Value("${file.path}")
    private String filePathString;

    @Autowired
     private Extractor extractor;

    @Scheduled(cron = "0 * * * * *")
    public void runService() {
        try {
            FileInputStream fis = new FileInputStream(new File(filePathString));
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);


            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            Iterator<Row> rowIterator = mySheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t");
                    } else if (cell.getCellTypeEnum() == CellType.NUMERIC)
                        System.out.print(cell.getNumericCellValue() + "\t");
                    else throw new UnknownCellTypeException(cell.getCellTypeEnum().toString());
                }
                System.out.println("");
            }

        } catch (FileNotFoundException e) {
            log.error("File on {} doesn't exist", filePathString, e);
        } catch (IOException e) {
            log.error("It's impossible to create Workbook from file", e);
        } catch (UnknownCellTypeException e) {
            log.error("Can't read data from unsupported cell type", e);
        }
    }
}
