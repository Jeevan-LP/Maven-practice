package DataDrivenExcel;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWritingStatic_01 {

	public static void main(String[] args) throws Throwable {

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\DataWritingStatic_01.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("SubjectDetails");
		
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("subject");
		row.createCell(1).setCellValue("Version");
		row.createCell(2).setCellValue("class room");
		row.createCell(3).setCellValue("Teacher name");
		
		XSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("java");
		row1.createCell(1).setCellValue("2.9");
		row1.createCell(2).setCellValue("27");
		row1.createCell(3).setCellValue("Jeevan");
		
		XSSFRow row2 = sheet.createRow(2);
		row2.createCell(0).setCellValue("automation");
		row2.createCell(1).setCellValue("5.4");
		row2.createCell(2).setCellValue("09");
		row2.createCell(3).setCellValue("Appu");
		
		/** its wont work
		//1st row
		sheet.createRow(0).createCell(0).setCellValue("subject");
		sheet.createRow(0).createCell(1).setCellValue("Version");
		sheet.createRow(0).createCell(2).setCellValue("class room");
		sheet.createRow(0).createCell(3).setCellValue("Teacher name");
		//2st row
		sheet.createRow(1).createCell(0).setCellValue("java");
		sheet.createRow(1).createCell(1).setCellValue("2.9");
		sheet.createRow(1).createCell(2).setCellValue("27");
		sheet.createRow(1).createCell(3).setCellValue("Jeevan");
		//3st row
		sheet.createRow(2).createCell(0).setCellValue("automation");
		sheet.createRow(2).createCell(1).setCellValue("5.4");
		sheet.createRow(2).createCell(2).setCellValue("09");
		sheet.createRow(2).createCell(3).setCellValue("Appu");
		**/
		
		
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("file created successfully");
		
	}

}
