package DataDrivenExcel;

import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWritingDynamic {

	public static void main(String[] args) throws Throwable {

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\DataWritingDynamic.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("DynamicData");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no rows?");
		int rows = sc.nextInt();
		System.out.println("enter no ?");
		int cells = sc.nextInt();
		
		for(int r=0;r<=rows;r++) {
			XSSFRow row = sheet.createRow(r);
			for(int c=0;c<=cells-1;c++) {
				row.createCell(c).setCellValue(sc.next());
				//This method wont work//sheet.createRow(r).createCell(c).setCellValue(sc.next());
				
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("file created successfully");
		
	}

}
