package DataDrivenExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static FileInputStream fInput;
	public static FileOutputStream fOutput;
	public static XSSFWorkbook XworkBook;
	public static XSSFSheet Xsheet;
	public static XSSFRow Xrow;
	public static XSSFCell Xcell;
	public static XSSFCellStyle Xstyle;
	
	public static int getRowNumber(String XLfileName, String XLsheetName) throws Throwable {
		fInput=new FileInputStream(XLfileName);
		XworkBook=new XSSFWorkbook(fInput);
		Xsheet=XworkBook.getSheet(XLsheetName);
		int RowNO=Xsheet.getLastRowNum();
		//System.out.println("Number of Rows "+RowNO);
		XworkBook.close();
		fInput.close();
		return RowNO;
	}
	
	public static int getCellNumber(String XLfileName, String XLsheetName, int Rows) throws Throwable {
		fInput=new FileInputStream(XLfileName);
		XworkBook=new XSSFWorkbook(fInput);
		Xsheet=XworkBook.getSheet(XLsheetName);
		Xrow=Xsheet.getRow(Rows);
		int CellNo=Xrow.getLastCellNum();
		//System.out.println("Number of Cells "+CellNo);
		XworkBook.close();
		fInput.close();
		return CellNo;
		
	}
	
	//public static String getCellSingleData(String XLfileName, String XLsheetName, int Rows, int cells)// both also correct
	public static String getCellData(String XLfileName, String XLsheetName, int Rows, int cells)throws Throwable {
		fInput=new FileInputStream(XLfileName);
		XworkBook=new XSSFWorkbook(fInput);
		Xsheet=XworkBook.getSheet(XLsheetName);
		Xrow=Xsheet.getRow(Rows);
		Xcell=Xrow.getCell(cells);

		String data;
		try {
		DataFormatter formatter = new DataFormatter();
		data=formatter.formatCellValue(Xcell);
		System.out.println(formatter.formatCellValue(Xcell));
		}
		catch (Exception e) {
			data="";
		}
		XworkBook.close();
		fInput.close();
		return data;
	}
	
	public static void getCellAllData(String XLfileName, String XLsheetName, int Rows) throws Throwable {
		fInput=new FileInputStream(XLfileName);
		XworkBook=new XSSFWorkbook(fInput);
		Xsheet=XworkBook.getSheet(XLsheetName);
		int rowNo=Xsheet.getLastRowNum();
		int cellNo = Xsheet.getRow(Rows).getLastCellNum();
		
		for(int r=0;r<=rowNo;r++) {
			Xrow=Xsheet.getRow(r);
			for(int c=0;c<=cellNo-1;c++) {
				Xcell=Xrow.getCell(c);
				String data;
				try {
				DataFormatter formatter = new DataFormatter();
				data=formatter.formatCellValue(Xcell);
				System.out.print(formatter.formatCellValue(Xcell)+"\t");
				}
				catch (Exception e) {
					data="";
				}
			}
			System.out.println();
		}
		
	}
		
	 public static void SetCellData(String XLfileName, String XLsheetName, int Rows, int cells, String data) throws Throwable {
		 fInput=new FileInputStream(XLfileName);
		 XworkBook=new XSSFWorkbook(fInput);
		 Xsheet=XworkBook.getSheet(XLsheetName);
		 Xrow=Xsheet.getRow(Rows);
		 
		 Xcell= Xrow.createCell(cells);
		 Xcell.setCellValue(data);
		 fOutput=new FileOutputStream(XLfileName);
		 XworkBook.write(fOutput);
		 XworkBook.close();
		 fInput.close();
		 fOutput.close();
	}
	
	 public static void fillGreenColor(String XLfileName, String XLsheetName, int Rows, int cell) throws Throwable {
		 fInput=new FileInputStream(XLfileName);
		 XworkBook=new XSSFWorkbook(fInput);
		 Xsheet=XworkBook.getSheet(XLfileName);
		 Xrow= Xsheet.getRow(Rows);
		 Xcell=Xrow.getCell(cell);
			
		 Xstyle=XworkBook.createCellStyle();
		 Xstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		 Xstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		 Xcell.setCellStyle(Xstyle);
			
		 fOutput=new FileOutputStream(XLfileName);
		 XworkBook.write(fOutput);
		 XworkBook.close();
		 fInput.close();
		 fOutput.close();
		}
		
	 public static void fillRedColor(String XLfileName, String XLsheetName, int Rows, int cells) throws Throwable {
		 fInput=new FileInputStream(XLfileName);
		 XworkBook=new XSSFWorkbook(fInput);
		 Xsheet=XworkBook.getSheet(XLfileName);
		 Xrow= Xsheet.getRow(Rows);
		 Xcell= Xrow.getCell(cells);
			
		 Xstyle=XworkBook.createCellStyle();
		 Xstyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		 Xstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		 Xcell.setCellStyle(Xstyle);
			
		 fOutput=new FileOutputStream(XLfileName);
		 XworkBook.write(fOutput);
		 XworkBook.close();
		 fInput.close();
		 fOutput.close();
		}
	 

}
