package com.shi.itextpdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextpdfTest {

	public static void main(String[] args) throws Exception {
		float[] widths = {144, 113, 191};
		FileOutputStream fos = new FileOutputStream("d:/itext5.pdf");
		 
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, fos);
		writer.setViewerPreferences(PdfWriter.PageModeUseThumbs);
		document.setPageSize(PageSize.A4);//����A4
		document.open();
		 
		PdfPTable table = new PdfPTable(widths);
		table.setTotalWidth(458);
		table.setHorizontalAlignment(Element.ALIGN_LEFT);
		 
		Object[][] datas = {{"����", "�����۶�(��Ԫ)", "������(��Ԫ)�򵥵ı��"}, {"����ʡ" , 9045,  2256}, {"�㶫ʡ", 3000, 690}};
		for(int i = 0; i < datas.length; i++) {
		    for(int j = 0; j < datas[i].length; j++) {
		        PdfPCell pdfCell = new PdfPCell(); //���ĵ�Ԫ��
		        Paragraph paragraph = new Paragraph(String.valueOf(datas[i][j]), getPdfChineseFont());
		        pdfCell.setPhrase(paragraph);
		        table.addCell(pdfCell);
		    }
		}
		 
		document.add(table); //pdf�ĵ��м���table
		document.close();
	}
	
	public static Font getPdfChineseFont() throws Exception {
	    BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
	            BaseFont.NOT_EMBEDDED);
	    Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
	    return fontChinese;
	}

}
