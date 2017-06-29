package utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataProvider{

	@SuppressWarnings("deprecation")
	public static String[][] getAllSheetData(String sheetName) {

		String[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(new File(sheetName));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);	
			int rowCount = sheet.getLastRowNum();	
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];		
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ 
						try {
							String cellValue = "";
							try{
								if(row.getCell(j).getCellType() == 1)
									cellValue = row.getCell(j).getStringCellValue();
								else if(row.getCell(j).getCellType() == 0)
									cellValue = ""+row.getCell(j).getNumericCellValue();

							}catch(NullPointerException e){

							}

							data[i-1][j]  = cellValue; 
						} catch (Exception e) {
 							e.printStackTrace();
						}				
					}

				} catch (Exception e) {
 					e.printStackTrace();
				}
			}
			fis.close();
			workbook.close();
		} catch (Exception e) {
 			e.printStackTrace();
		}

		return data;

		
		
	}


}
