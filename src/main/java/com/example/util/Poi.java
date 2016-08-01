package com.example.util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by maomao on 16/8/1.
 */
@Component
public class Poi {
    public void xlsxTest(MultipartFile multipartFile) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(multipartFile.getInputStream());
        xssfWorkbook.forEach(
            xssfSheet -> xssfSheet.forEach(
                xssfRow -> xssfRow.forEach(
                    xssfCell -> {
                        if (null != xssfCell) {
                            System.out.println("row index :" + xssfCell.getRowIndex()
                                + " column index :" + xssfCell.getColumnIndex()
                                + " value " + xssfCell.getStringCellValue());
                        }
                    }
                )
            )
        );
    }

    public void xlsTest(MultipartFile multipartFile) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(multipartFile.getInputStream());
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            hssfSheet.forEach(
                hssfRow -> hssfRow.forEach(
                    hssfCell -> {
                        if (null != hssfCell) {
                            System.out.println("row index :" + hssfCell.getRowIndex()
                                + " column index :" + hssfCell.getColumnIndex()
                                + " value " + hssfCell.getStringCellValue());
                        }
                    }));
        }
    }
}
