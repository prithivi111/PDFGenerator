package org.example;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExtratingTheParticularPage {

    public static void main(String[] args) throws IOException {
    File file = new File("C:/Users/s011271sur/intellij/PDFGenerator/src/main/resources/September-December 2023.pdf");
    PDDocument pdDocument = PDDocument.load(file);

    //We are creating splitter object to split the pdffile
    Splitter splitter = new Splitter();
    splitter.setStartPage(2);
    splitter.setEndPage(4);

    int num=1;
    List<PDDocument> splitPages = splitter.split(pdDocument);

    //We are creating new object to combine all the splitted files into one pdf.
    PDDocument newpdDocument = new PDDocument();
    File newDestination = new File("C:/Users/s011271sur/intellij/PDFGenerator/src/main/resources/");

        for(PDDocument mydoc: splitPages){
            newpdDocument.addPage(mydoc.getPage(0));
          }

        newpdDocument.save(newDestination+"/newSplitted.pdf");
        newpdDocument.close();

        System.out.println("New PDF created of page 2 to 4");
    }

}
