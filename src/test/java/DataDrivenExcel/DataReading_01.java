package DataDrivenExcel;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReading_01 {

	public static void main(String[] args) throws Throwable {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Student.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("ClassDetails");
		int rowsNo = sheet.getLastRowNum();
		System.out.println(rowsNo);
		int cellNo = sheet.getRow(rowsNo).getLastCellNum();
		System.out.println(cellNo);
		
		///Reading all data from excel file
		for(int r=0;r<=rowsNo;r++) {
			XSSFRow rows = sheet.getRow(r);
			for(int c=0;c<=cellNo-1;c++) {
				//String Alldata = rows.getCell(c).toString();
				String Alldata = sheet.getRow(r).getCell(c).toString();
				System.out.print(Alldata+"\t");
				
				/** another method to read all data form excel file
				XSSFCell cell = sheet.getRow(r).getCell(c);
				DataFormatter alldata = new DataFormatter();
				System.out.print(alldata.formatCellValue(cell)+"\t");
				**/
				}
			System.out.println();

		}
		///Reading single data from excel file
		String singleData = sheet.getRow(3).getCell(1).toString();
		System.out.println(singleData);
		
	}

}
