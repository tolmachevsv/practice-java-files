package com.tolmachevsv.tests;

import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ZipFileWithPwdTest {

    @Test
    public void ZipTest() throws IOException {
        String unzipFileAddress = "src/test/resources/zip/sample.zip";
        String destinationAddress = "src/test/resources/zip/";
        // если сменить пароль, упадет ошибка "Wrong password"
        String password = "1234";

        try (ZipFile currentFile = new ZipFile(unzipFileAddress, password.toCharArray())) {
            currentFile.extractFile("sample.txt", destinationAddress);
            } catch (Exception e) {
            e.printStackTrace();
        }

        // Запись в переменную извлеченного файла
        File extractedFile = new File("src/test/resources/zip/sample.txt");

        // Проверка содержимое файла
        String fileText = FileUtils.readFileToString(extractedFile, "UTF-8");
        Assertions.assertTrue(fileText.contains("I would love to try or hear the sample audio your app can produce"));

        // Удаление файла в конце проверки
        boolean result = Files.deleteIfExists(Path.of("src/test/resources/zip/sample.txt"));
    }
}

