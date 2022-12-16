package com.tolmachevsv.tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class PdfFileTest {

    @Test
    public void SimplePdfTest() throws IOException {
        PDF currentFile = new PDF(new File("src/test/resources/pdf_file.pdf"));

        assertThat(currentFile.text).contains("A Simple PDF File");
    }
}
