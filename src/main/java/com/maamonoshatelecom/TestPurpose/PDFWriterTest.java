package com.maamonoshatelecom.TestPurpose;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFWriterTest {

	public static void main(String[] args) {
		
		String savedLocation = "D:/maamonosha.com/maamonosha.com/maamonoshatelecom/src/main/resources/static";
		
		 Document document = new Document();
	        try {
	            PdfWriter.getInstance(document, new FileOutputStream(savedLocation+"/example1.pdf"));
	            document.open();
	            document.add(new Paragraph("Hello, World!"));
	            document.addSubject("Download Invoice");

	            // Add more content to the PDF here

	            document.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
}
