package com.pig.Utils;

import com.pig.model.Login;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xdgf.usermodel.XDGFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class WriteUtil {

	public static final int LOGIN = 3; // nếu test login thì kết quả sẽ ghi vào cột số 4
	public static final int REGISTRATION = 7; // nếu test login thì kết quả sẽ ghi vào cột số 8

	public static void write(String fileName, List<Boolean> results, int flagPage) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);

			WriteUtil.writeResults(file, results, flagPage);
		}
	}

	private static void writeResults(File file, List<Boolean> results, int flagPage) {
		if (file != null) {
			try {
				// Create a new workbook
				FileInputStream fileInputStream = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
				XSSFSheet sheet = null;

				// dua vao flagPage de xac dinh se~ ghi ket qua vao sheet nao
				switch (flagPage) {
					case LOGIN:{
						sheet =  workbook.getSheetAt(0);
					}
					case REGISTRATION: {
						sheet =  workbook.getSheetAt(1);
					}
				}
//				// Create a new sheet
//				XSSFSheet sheet = workbook.createSheet("Students");

				if (sheet != null && sheet.getLastRowNum() > 0) {

					// Create header row
//					Row header = sheet.createRow(0);
					// Code
//					Cell cell = header.createCell(0);
//					cell.setCellValue("Code");

					// Create content rows
					int length = results != null ? results.size() : 0;
					for (int i = 0; i < length; i++) {

						Boolean result = results.get(i);
						// Create content row
						Row row = sheet.getRow(i + 1);
						// dựa vào flagPage để ghi kết quả vào cột
						Cell cell = row.createCell(flagPage);
						if (result != null) {
							cell.setCellValue(result ? "PASS" : "FAIL");
						} else {
							cell.setCellValue("FAIL");
						}
					}
				}

				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}