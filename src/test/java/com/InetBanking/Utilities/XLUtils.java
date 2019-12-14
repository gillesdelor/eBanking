package com.InetBanking.Utilities;
	
	import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
	 
	import java.io.FileInputStream;
    import java.io.FileOutputStream;
	import java.io.IOException;
	 
	public class XLUtils {
	
	    public static FileInputStream fi;
	    public static FileOutputStream fo;
	    public static HSSFWorkbook WBook;
	    public static HSSFSheet WSheet;
	    public static HSSFRow row;
	    public static HSSFCell cell;
	   
	    //Setter and Getters of row and columns
	    public static int getRowCount (String xlfile, String xlsheet) throws IOException 
	    {
	        fi = new FileInputStream (xlfile);
	        WBook = new HSSFWorkbook(fi);
	        WSheet = WBook.getSheet(xlsheet);
	        int rowcount = WSheet.getLastRowNum();
	        WBook.close();
	        fi.close();
	        return rowcount;    
	    }    
	    
	  //Setters and Getters of row and cell
	    public static int getCellCount (String xlfile, String xlsheet, int rownum) throws IOException 
	    {
	        fi = new FileInputStream (xlfile);
	        WBook = new HSSFWorkbook(fi);
	        WSheet = WBook.getSheet(xlsheet);
	        row = WSheet.getRow(rownum);
	        int cellcount = row.getLastCellNum();
	        WBook.close();
	        fi.close();
	        return cellcount;    
	    }
	     
		  // Getters of data and read from the file
		    public static String getCellData (String xlfile, String xlsheet, int rownum, int colnum) throws IOException 
		    {
		        fi = new FileInputStream (xlfile);
		        WBook = new HSSFWorkbook(fi);
		        WSheet = WBook.getSheet(xlsheet);
		        row = WSheet.getRow(rownum);
		        cell = row.getCell(colnum);
		        String data;
		        try
		        {
		        	DataFormatter formatter = new DataFormatter();
		        	String cellData = formatter.formatCellValue(cell);
		        	return cellData;
		        }
		        catch (Exception e)
		        {
		        	data = "";
		        }
		      WBook.close();
		      fi.close();
		      return data;	   
		    }

		  //Setter of data and write data from the file
		    public static void setCellData (String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException 
		    {
		        fi = new FileInputStream (xlfile);
		        WBook = new HSSFWorkbook(fi);
		        WSheet = WBook.getSheet(xlsheet);
		        row = WSheet.getRow(rownum);
		        cell = row.createCell(colnum);
		        cell.setCellValue(data);
		        fo = new FileOutputStream(xlfile);
		        WBook.write(fo);
		        WBook.close();
		        fi.close();
		        fo.close();
		    }		        
}
