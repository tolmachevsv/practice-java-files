package com.tolmachevsv.tests;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileWithoutPwdTest {

    @Test
    public void ZipTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String entryAsString = null;
        InputStream resourceAsStream = classLoader.getResourceAsStream("zip/zip_file.zip");
        try (ZipInputStream stream = new ZipInputStream(Objects.requireNonNull(resourceAsStream))) {
            while ((stream.getNextEntry()) != null) {
                entryAsString = IOUtils.toString(stream, StandardCharsets.UTF_8);
            }
            Assertions.assertTrue(entryAsString.contains("I would love to try or hear the sample audio your app can produce"));
        }
    }
}
