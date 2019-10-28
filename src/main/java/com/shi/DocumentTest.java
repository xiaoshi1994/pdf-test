package com.shi;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.print.attribute.standard.PageRanges;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 测试导出 横向导出pdf
 * 
 * @author shiye
 *
 */
public class DocumentTest {

	public static void main(String[] args) {
		try {
			testNewDocument();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void testNewDocument() throws FileNotFoundException, DocumentException {
		Rectangle rect = new Rectangle(0,0,800,600);  
        Document document = new Document(rect);
		PdfWriter.getInstance(document, new FileOutputStream("d:/NewDocumentMargin.pdf"));
		document.open();
		document.add(new Paragraph("Hello World"));

		document.close();
	}

}
