package testyantra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Example {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(new File("./data/data.xlsx"));
		Workbook wb = WorkbookFactory.create(fis);
		String x = wb.getSheet("sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(x);
//		wb.createSheet("aksh");
//		FileOutputStream fos = new FileOutputStream(new File("./data/data.xlsx"));
//		wb.write(fos);
		//wb.
	}

}
