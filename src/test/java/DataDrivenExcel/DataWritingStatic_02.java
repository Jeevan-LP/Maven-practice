package DataDrivenExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWritingStatic_02 {

	public static void main(String[] args) throws Throwable {

		String filePath=System.getProperty("user.dir")+"\\TestData\\DataWritingStatic_02.xlsx";
		String sheetName="DataWritingStatic_02";
		
		FileOutputStream fi = new FileOutputStream(filePath);
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet(sheetName);
		
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("SL NO");
		row1.createCell(1).setCellValue("Teacher Name");
		row1.createCell(2).setCellValue("Subject");
		row1.createCell(3).setCellValue("Timings");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("1");
		row2.createCell(1).setCellValue("Priyanka NM");
		row2.createCell(2).setCellValue("SOM");
		row2.createCell(3).setCellValue("09:00");
		
		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("2");
		row3.createCell(1).setCellValue("Theju R K");
		row3.createCell(2).setCellValue("RCC");
		row3.createCell(3).setCellValue("10:00");
		
		XSSFRow row4 = sheet.createRow(3);
		row4.createCell(0).setCellValue("3");
		row4.createCell(1).setCellValue("Santhosh");
		row4.createCell(2).setCellValue("Railway Engg");
		row4.createCell(3).setCellValue("11:00");
		
		workBook.write(fi);
		System.out.println("New file created successfully");
		
		FileInputStream fo = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fo);
		XSSFSheet sheetInput = wb.getSheet(sheetName);
		int RowsNo = sheetInput.getLastRowNum();
		System.out.println("Number of rows "+RowsNo);
		int CellNo = sheetInput.getRow(RowsNo).getLastCellNum();
		System.out.println("Number of cells "+CellNo);
		
		for(int r=0;r<=RowsNo;r++) {
			XSSFRow row = sheet.getRow(r);
			for(int c=0;c<=CellNo-1;c++) {
				XSSFCell cellData = row.getCell(c);
				DataFormatter formatter = new DataFormatter();
				System.out.print(formatter.formatCellValue(cellData)+"\t");
			}
			System.out.println();
			
		}
		
		wb.close();
		fo.close();
		System.out.println("All data retrieved successfully");
	}

}
