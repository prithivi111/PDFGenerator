package org.example;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SplittingPDF {

    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/s011271sur/intellij/PDFGenerator/src/main/resources/September-December 2023.pdf");
        PDDocument pdDocument = PDDocument.load(file);

        //Splitting the file
        Splitter splitter = new Splitter();

        int num=1;
        List<PDDocument> splitPages = splitter.split(pdDocument);
        for(PDDocument mydoc: splitPages){
            mydoc.save("C:/Users/s011271sur/intellij/PDFGenerator/src/main/resources/split_"+num +".pdf");
            num++;
            mydoc.close();
        }

        System.out.println("Split Done");
    }
}