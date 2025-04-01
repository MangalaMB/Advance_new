package Z_DDTPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTByExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(("C:\\Users\\Manga\\eclipse-workspace\\BasicSelenium\\src\\test\\resources\\Data.xlsx"));
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("DDT").getRow(0).getCell(0).getStringCellValue();
		String data1 = wb.getSheet("DDT").getRow(1).getCell(1).getStringCellValue();
				System.out.println(data);
				System.out.println(data1);	
	}

}
