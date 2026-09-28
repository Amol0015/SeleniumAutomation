package com.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTesting1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		  // १. व्हेरिएबल्स सुरुवातीला डिक्लेअर केले
	    XSSFWorkbook excelbook = null;
	    XSSFSheet excelsheet = null;
	    FileInputStream inputStream = null;

	    // २. फाईल क्लासचा ऑब्जेक्ट तयार करणे
	    File excelFile = new File("C:\\Amol\\Total Project\\TestDataFile.xlsx");
	    
	    try {
	        // ३. फाईल इनपुट स्ट्रीम सुरू करणे
	        inputStream = new FileInputStream(excelFile);
	        
	        // ४. वर्कबुक आणि शीट एक्सेस करणे
	        excelbook = new XSSFWorkbook(inputStream);
	        excelsheet = excelbook.getSheetAt(0);
	        
	        // ५. एकूण Rows आणि Cells ची संख्या मोजणे
	        int ttlRows = excelsheet.getLastRowNum() + 1;
	        int ttlCells = excelsheet.getRow(0).getLastCellNum(); // दुरुस्ती: इथे +1 करण्याची गरज नसते

	        System.out.println("--- एक्सल फाईल मधील डेटा खालीलप्रमाणे आहे ---\n");

	        // ६. डेटा व्यवस्थित प्रिंट करण्यासाठी लूप
	        for (int currentRow = 0; currentRow < ttlRows; currentRow++) {
	            
	            for (int currentCell = 0; currentCell < ttlCells; currentCell++) {
	                
	                // सेल मधील डेटा वाचणे
	                String cellData = excelsheet.getRow(currentRow).getCell(currentCell).toString();
	                
	                // दुरुस्ती: System.out.print वापरल्यामुळे डेटा एकाच ओळीत शेजारी प्रिंट होईल
	                System.out.print(cellData + "\t"); 
	            }
	            
	            // दुरुस्ती: एक पूर्ण रो प्रिंट झाल्यावर नवीन ओळीवर (New Line) जाण्यासाठी
	            System.out.println(); 
	        }

	    } catch (FileNotFoundException e) {
	        System.out.println("एक्सल फाईल सापडली नाही: " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("फाईल वाचताना एरर आली: " + e.getMessage());
	    } finally {
	        // ७. उघडलेल्या फाईल्स सुरक्षितपणे बंद करणे (Best Practice)
	        try {
	            if (excelbook != null) excelbook.close();
	            if (inputStream != null) inputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
