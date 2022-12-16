package com.tolmachevsv.tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class XlsFileTest {

    @Test
    public void SimpleXlsTest() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("xls_file.xls");
        assert stream != null;
        XLS xlsFile = new XLS(stream);
        String cellValue = xlsFile.excel.getSheetAt(1).getRow(0).getCell(0).getStringCellValue();
        Assertions.assertEquals("test2", cellValue);
    }
}
