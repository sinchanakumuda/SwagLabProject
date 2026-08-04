package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException
	{
	//Excel Utility
			FileInputStream fs1=new FileInputStream("./src/test/resources/testdata.xlsx");
			Workbook wb=WorkbookFactory.create(fs1);
			Sheet sh=wb.getSheet("Sheet1");
			
			
			DataFormatter f=new DataFormatter();
			String data=f.formatCellValue(sh.getRow(row).getCell(cell));
			
			
			return data;
	}
	
	
	

}
