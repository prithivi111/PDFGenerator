package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;

public class AddingImageAndCreatingTable {
    public static void main(String[] args) throws IOException {
        PDDocument document= new PDDocument();
        PDPage pdPage = new PDPage();
        document.addPage(pdPage);

        //We need to create image object, where we need to mention the path of the image and the main object from where
        // we will be accessing the image
        PDImageXObject image1 = PDImageXObject.createFromFile("C:/Users/s011271sur/intellij/PDFGenerator/src/main/resources/Season.jpg", document);

        //Now we need to use the PDPageContentStream, mentioning the main object and the page object
        PDPageContentStream pdPageContentStream = new PDPageContentStream(document, pdPage);

        //Now we need to draw the image including where to put image mentioning x and y axis
        pdPageContentStream.drawImage(image1, 30,550, 200, 200);

        //We successfully drawn the image of Season on the left side of the page.
        //Now lets try to make the table of the right side of the Season's image.

        int pageHeight = (int) pdPage.getTrimBox().getHeight();
        int pageWidth = (int) pdPage.getTrimBox().getWidth();

        pdPageContentStream.setStrokingColor(Color.BLUE); //this is the color of the table line
        pdPageContentStream.setLineWidth(1); //this is the width of table line

        int initX = 250; //Since the start axis of season's image is from 30 and width of image is 200 above, I started table pointer from 250.
        int initY = pageHeight - 100;
        int cellHeight = 30;
        int cellWidth = 70;

        int colCount = 5;
        int roCount = 5;

            for (int i=1; i<roCount; i++){
                for(int j=1; j<colCount; j++){
                    //here we need to create rectangle
                    pdPageContentStream.addRect(initX,initY,cellWidth,-cellHeight);

                    //Writing inside the table
                    pdPageContentStream.beginText();
                    pdPageContentStream.newLineAtOffset(initX+10, initY- cellHeight + 10);
                    pdPageContentStream.setFont(PDType1Font.TIMES_ROMAN,12);
                    pdPageContentStream.showText("Hello");
                    pdPageContentStream.endText();

                    initX+=cellWidth;
                }
                initX =250;
                initY -=cellHeight;
            }

            pdPageContentStream.stroke(); //this will use the stroke men
        pdPageContentStream.close();

        document.save("C:/Users/s011271sur/intellij/PDFGenerator/src/main/resources/seasonImage.pdf");
        document.close();

        System.out.println("NEW PDF created with season image");

    }
}
