package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  XSSFWorkbook wb;
	public  XSSFSheet st;
	public  XSSFRow row;
	public  XSSFCell col;
	String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String xlSheet ) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(xlSheet);
		
		int rowCout=st.getLastRowNum();
		
		wb.close();
		fi.close();
		
		return rowCout;
		
	}
	
	public int getCellCount(String xlSheet,int rowNum ) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(xlSheet);
		
		int cellCount=st.getRow(rowNum).getLastCellNum();
		
		wb.close();
		fi.close();
		
		return cellCount;
		
	}
	
	public String getCellData(String xlSheet,int rowNum,int cellNum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(xlSheet);
		row=st.getRow(rowNum);
		col=row.getCell(cellNum);
		
		String data;
		//data=cl.toString();
		try
		{
		DataFormatter formatter = new DataFormatter();
		data= formatter.formatCellValue(col);
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
		
	}
	
	public void createRow(String xlSheet,int rowNum) throws IOException
	{
		
		wb=new XSSFWorkbook();
		//st=wb.getSheet(xlSheet);
		st=wb.createSheet("Sheet1");
		row=st.createRow(rowNum);
		
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fo.close();
			
	}
	
	
	public void setCellData(String xlSheet,int rowNum,int cellNum,String data) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(xlSheet);
		row=st.getRow(rowNum);
		//row=st.createRow(rowNum);
		col=row.createCell(cellNum);
		col.setCellValue(data);
		
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fo.close();
			
	}
	
	public void getSetCellData(String xlSheet,int rowNum,int cellNum,String data) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		st=wb.getSheet(xlSheet);
		row=st.getRow(rowNum);
		
		col=row.createCell(cellNum);
		col.setCellValue(data);
		
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
			
	}

	
}
