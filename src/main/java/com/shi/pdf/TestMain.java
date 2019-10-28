//package com.shi.pdf;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.itextpdf.kernel.color.DeviceRgb;
//import com.itextpdf.kernel.events.PdfDocumentEvent;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.property.HorizontalAlignment;
//import com.itextpdf.layout.property.TextAlignment;
//import com.itextpdf.layout.property.UnitValue;
//
//public class TestMain {
//
//	public static void main(String[] args) {
//		List<TableVo> tables = new ArrayList<TableVo>();
//		
//		for (int i = 0; i < 5; i++) {
//			TableVo tablevo = new TableVo();
//			tablevo.setTableName("tableName"+i);
//			tablevo.setTableComment("tableComment"+i);
//			List<ColumnVo> columns = new ArrayList<ColumnVo>();
//			for (int j = 0; j < 2; j++) {
//				ColumnVo columnVo = new ColumnVo();
//				columnVo.setColumnComment("ColumnComment"+j);
//				columnVo.setColumnKey("columnKey"+j);
//				columnVo.setColumnName("columnName"+j);
//				columnVo.setColumnType("columnType"+j);
//				columnVo.setIsNullable("isNullable"+j);
//				columns.add(columnVo);
//			}
//			tablevo.setColumns(columns);
//			
//			tables.add(tablevo);
//		}
//		
//		String createPdf = createPdf(tables);
//		System.out.println(createPdf);
//	}
//	
//
//	public static String createPdf(List<TableVo> tables) {
//	 
//		try {
//			PdfDocument pdfDoc = new PdfDocument(
//					new PdfWriter("d:/itext7.pdf"));
//			Document doc = new Document(pdfDoc);// 构建文档对象
//			TextFooterEventHandler eh = new TextFooterEventHandler(doc);
//			pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, eh);
//			// 中文字体
//			PdfFont sysFont = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
//			Paragraph paragraph = new Paragraph();
//			paragraph.add("数据库设计文档").setFont(sysFont).setBold().setFontSize(20).setTextAlignment(TextAlignment.CENTER);
//			doc.add(paragraph);
//			int num = 0;
//			for (TableVo vo : tables) {
//				num++;
//				doc.add(new Paragraph(""));
//				String title = num +"  表名：" + vo.getTableName() + "   表注释：" + vo.getTableComment();
//				doc.add(new Paragraph(title).setFont(sysFont).setBold());
//				// 构建表格以100%的宽度
//				Table table = new Table(5).setWidth(UnitValue.createPercentValue(100));
//	 
//				table.addCell(new Cell().add(new Paragraph("列名")).setFont(sysFont)
//						.setBackgroundColor(new DeviceRgb(221, 234, 238)));
//				table.addCell(new Cell().add(new Paragraph("数据类型")).setFont(sysFont)
//						.setBackgroundColor(new DeviceRgb(221, 234, 238)));
//				table.addCell(new Cell().add(new Paragraph("约束")).setFont(sysFont)
//						.setBackgroundColor(new DeviceRgb(221, 234, 238)));
//				table.addCell(new Cell().add(new Paragraph("允许空")).setFont(sysFont)
//						.setBackgroundColor(new DeviceRgb(221, 234, 238)));
//				table.addCell(new Cell().add(new Paragraph("备注")).setFont(sysFont)
//						.setBackgroundColor(new DeviceRgb(221, 234, 238)));
//				for (ColumnVo col : vo.getColumns()) {
//					table.addCell(new Cell().add(new Paragraph(col.getColumnName())).setFont(sysFont));
//					table.addCell(new Cell().add(new Paragraph(col.getColumnType())).setFont(sysFont));
//					table.addCell(new Cell().add(new Paragraph(col.getColumnKey())).setFont(sysFont));
//					table.addCell(new Cell().add(new Paragraph(col.getIsNullable())).setFont(sysFont));
//					table.addCell(new Cell().add(new Paragraph(col.getColumnComment())).setFont(sysFont));
//				}
//				// 将表格添加入文档并页面居中
//				doc.add(table.setHorizontalAlignment(HorizontalAlignment.CENTER));
//			}
//			doc.close();
//			return "文件路径-" + "d:/itext7.pdf";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "导出失败！请检查配置。";
//	}
//	
//
//}
//
//class TableVo{
//	private String tableName;
//	private String tableComment;
//	private List<ColumnVo> columns;
//
//	public List<ColumnVo> getColumns() {
//		return columns;
//	}
//
//	public void setColumns(List<ColumnVo> columns) {
//		this.columns = columns;
//	}
//
//	public String getTableName() {
//		return tableName;
//	}
//
//	public void setTableName(String tableName) {
//		this.tableName = tableName;
//	}
//
//	public String getTableComment() {
//		return tableComment;
//	}
//
//	public void setTableComment(String tableComment) {
//		this.tableComment = tableComment;
//	}
//	
//}
//
//class ColumnVo{
//	private String columnName;
//	private String columnType;
//	private String columnKey;
//	private String isNullable;
//	private String columnComment;
//	public String getColumnName() {
//		return columnName;
//	}
//	public void setColumnName(String columnName) {
//		this.columnName = columnName;
//	}
//	public String getColumnType() {
//		return columnType;
//	}
//	public void setColumnType(String columnType) {
//		this.columnType = columnType;
//	}
//	public String getColumnKey() {
//		return columnKey;
//	}
//	public void setColumnKey(String columnKey) {
//		this.columnKey = columnKey;
//	}
//	public String getIsNullable() {
//		return isNullable;
//	}
//	public void setIsNullable(String isNullable) {
//		this.isNullable = isNullable;
//	}
//	public String getColumnComment() {
//		return columnComment;
//	}
//	public void setColumnComment(String columnComment) {
//		this.columnComment = columnComment;
//	}
//	
//}
