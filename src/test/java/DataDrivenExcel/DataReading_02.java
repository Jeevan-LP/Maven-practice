package DataDrivenExcel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReading_02 {

	public static void main(String[] args) throws Throwable {

		String filePath=System.getProperty("user.dir")+"\\TestData\\Practice.xlsx";
		String sheetName="Data";
		
		FileInputStream file = new FileInputStream(filePath);
		
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		
		int RowsNo = sheet.getLastRowNum();
		System.out.println("Number of rows "+RowsNo);///start from '0'
		int CellNo=sheet.getRow(RowsNo).getLastCellNum();
		System.out.println("Number of cells "+CellNo);///start from '1'
		
		////Approach 1 to retrieve single data from excel
		//While retrieving single/multiple data from excel file all rows/cells considered as a index No '0'
		String singleData = sheet.getRow(2).getCell(2).toString();
		System.out.println(singleData);
		
		////Approach 2 to retrieve single data from excel
		XSSFCell SingleCellData = sheet.getRow(1).getCell(5);
		DataFormatter formatter = new DataFormatter();
		System.out.println(formatter.formatCellValue(SingleCellData));
		
		for(int r=0;r<=RowsNo;r++) {
			XSSFRow row = sheet.getRow(r);
			for(int c=0;c<=CellNo-1;c++) {
				//Approach 1 to retrieve all data
				/**
				String allData = row.getCell(c).toString();
				System.out.print(allData+"\t");
				**/
				//Approach 1 to retrieve all data---most of the time use below method
				XSSFCell allData = sheet.getRow(r).getCell(c);
				DataFormatter dataFormatter=new DataFormatter();
				System.out.print(dataFormatter.formatCellValue(allData)+"\t");
			}
			System.out.println();
		}
		
	}

}
