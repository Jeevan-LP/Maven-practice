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


public class ExcelUtilityDemo {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook xw;
	public static XSSFSheet xs;
	public static XSSFRow xr;
	public static XSSFCell xc;
	public static XSSFCellStyle style;


	public static int getRowCount(String XLfile , String XLsheet) throws Throwable {
		fi=new FileInputStream(XLfile);
		xw=new XSSFWorkbook(fi);
		xs=xw.getSheet(XLsheet);
		int rowCount = xs.getLastRowNum();
		System.out.println("Number of rows "+rowCount);
		xw.close();
		fi.close();
		return rowCount;
		
	}
	
	public static int getCellCount(String XLfile, String XLsheet, int rownum) throws Throwable {
		fi=new FileInputStream(XLfile);
		xw=new XSSFWorkbook(fi);
		xs=xw.getSheet(XLsheet);
		xr= xs.getRow(rownum);
		int cell = xr.getLastCellNum();
		System.out.println("Number of cells "+cell);
		xw.close();
		fi.close();
		return cell;
	}
	
	public static String getCellData(String XLfile, String XLsheet, int rownum, int column) throws Throwable {
		fi=new FileInputStream(XLfile);
		xw=new XSSFWorkbook(fi);
		xs=xw.getSheet(XLsheet);
		xr= xs.getRow(rownum);
		xc= xr.getCell(column);
		
		String data = null;
		try {
		DataFormatter Formatter = new DataFormatter();
		Formatter.formatCellValue(xc);
		System.out.println(Formatter.formatCellValue(xc));
		}
		catch (Exception e) {
			data="";
		}
		xw.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String XLfile, String XLsheet, int rownum, int column, String data) throws Throwable {
		fi=new FileInputStream(XLfile);
		xw=new XSSFWorkbook(fi);
		xs=xw.getSheet(XLsheet);
		xr= xs.getRow(rownum);
		xc= xr.createCell(column);
		xc.setCellValue(data);
		fo=new FileOutputStream(XLfile);
		xw.write(fo);
		xw.close();
		fi.close();
		
	}
	
	public static void fillGreenColor(String XLfile, String XLsheet, int rownum, int column) throws Throwable {
		fi=new FileInputStream(XLfile);
		xw=new XSSFWorkbook(fi);
		xs=xw.getSheet(XLsheet);
		xr= xs.getRow(rownum);
		xc= xr.createCell(column);
		
		style=xw.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		xc.setCellStyle(style);
		
		fo=new FileOutputStream(XLfile);
		xw.write(fo);
		xw.close();
		fi.close();
		fo.close();
	}
	
	public static void fillRedColor(String XLfile, String XLsheet, int rownum, int column) throws Throwable {
		fi=new FileInputStream(XLfile);
		xw=new XSSFWorkbook(fi);
		xs=xw.getSheet(XLsheet);
		xr= xs.getRow(rownum);
		xc= xr.createCell(column);
		
		style=xw.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		xc.setCellStyle(style);
		
		fo=new FileOutputStream(XLfile);
		xw.write(fo);
		xw.close();
		fi.close();
		fo.close();
	}
	
	
	
}
