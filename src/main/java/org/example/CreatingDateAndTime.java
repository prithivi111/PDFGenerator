package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatingDateAndTime {
    public static void main(String[] args) throws IOException {
        PDDocument pdDocument = new PDDocument();

        // Setting the PDFPageSize

        PDPage pdPage = new PDPage();
        pdDocument.addPage(pdPage);

        PDPageContentStream pdPageContentStream = new PDPageContentStream(pdDocument, pdPage);
        pdPageContentStream.beginText();
        pdPageContentStream.setFont(PDType1Font.TIMES_ROMAN,12);
        pdPageContentStream.newLineAtOffset(50, 700);
        pdPageContentStream.showText("This is your current document");
        pdPageContentStream.newLine();

        //Using date and time format
        DateFormat d_format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String formattedDate = d_format.format(date);

        //Now moving the line to offsetting 0 units at x axis and -40 (going down) units y axis with respect to previous line).
        pdPageContentStream.newLineAtOffset(0,-40);
        pdPageContentStream.showText("Generated on: "+ formattedDate);

        pdPageContentStream.endText();
        pdPageContentStream.close();

        pdDocument.save("C:/Users/s011271sur/intellij/PDFGenerator/src/main/resources/PageSize.pdf");
        pdDocument.close();
        System.out.println("New pdf created");
    }
}
