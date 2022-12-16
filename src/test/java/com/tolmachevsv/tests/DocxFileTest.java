package com.tolmachevsv.tests;

import jakarta.xml.bind.JAXBElement;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Text;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DocxFileTest {

    @Test
    public void DocxTest() throws Exception {
        // я хз, тут чистая магия
        File doc = new File("src/test/resources/docx_file.docx");
        WordprocessingMLPackage wordFile = Docx4J.load(doc);
        MainDocumentPart mainDocumentPart = wordFile.getMainDocumentPart();
        String textNodesXPath = "//w:t";
        List<Object> textNodes = mainDocumentPart.getJAXBNodesViaXPath(textNodesXPath, true);
        List<String> rows = new ArrayList<>();
        for (Object obj : textNodes) {
            Text text = (Text) ((JAXBElement<?>) obj).getValue();
            String textValue = text.getValue();
            rows.add(textValue);
        }
        Assertions.assertTrue(rows.contains("Demonstration of DOCX support in calibre"));
    }
}
