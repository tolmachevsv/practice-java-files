package com.tolmachevsv.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TxtFileTest {

    @Test
    public void simpleTxtTest() throws Exception {
        File currentFile = new File("src/test/resources/text_file.txt");

        String fileText = FileUtils.readFileToString(currentFile, "UTF-8");
        Assertions.assertTrue(fileText.contains("Test document"));

        /*
                Второй вариант:
                String fileText1;

                try (InputStream is = new FileInputStream(currentFile)) {
                    fileText1 = new String(is.readAllBytes());
                }
                System.out.println(fileText1);
        */
    }
}
