package com.pig.Utils;

import com.pig.model.Login;
import com.pig.model.Registration;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ReadUtil {

	public static List<Login> readLogins(String fileName) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);

			return readLogins(file);
		}
		return null;
	}

	public static List<Registration> readRegistrations(String fileName) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);

			return readRegistrations(file);
		}
		return null;
	}

	private static List<Registration> readRegistrations(File file) {
		if (file != null && file.canRead()) {
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
				DataFormatter dataFormatter = new DataFormatter();
				// Get first sheet
				XSSFSheet sheet = workbook.getSheetAt(1);
				List<Registration> registrationDataList = new ArrayList<Registration>();
				if (sheet != null && sheet.getLastRowNum() > 0) {
					// Because first row is header, i index will start at 1
					for (int i = 1; i <= sheet.getLastRowNum(); i++) {

						Row row = sheet.getRow(i);
						if (row != null && row.getLastCellNum() > 0) {
							Registration registration = new Registration();
							Cell cell = row.getCell(0);
							registration.setName(Objects.isNull(cell) ? "" : dataFormatter.formatCellValue(cell));

							cell = row.getCell(1);
							registration.setEmail(Objects.isNull(cell) ? "" : dataFormatter.formatCellValue(cell));

							cell = row.getCell(2);
							registration.setPass(Objects.isNull(cell) ? "" : dataFormatter.formatCellValue(cell));

							cell = row.getCell(3);
							registration.setPassRepeat(Objects.isNull(cell) ? "" : dataFormatter.formatCellValue(cell));

							cell = row.getCell(4);
							registration.setAddress(Objects.isNull(cell) ? "" : dataFormatter.formatCellValue(cell));

							cell = row.getCell(5);
							registration.setPhone(Objects.isNull(cell) ? "" : dataFormatter.formatCellValue(cell));

							cell = row.getCell(6);
							registration.setMessageResult(Objects.isNull(cell) ? "" : dataFormatter.formatCellValue(cell));

							registrationDataList.add(registration);
						}
					}
					// Note: You have to close workbook.
					workbook.close();
					return registrationDataList;
				}
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private static List<Login> readLogins(File file) {
		if (file != null && file.canRead()) {
			try {
				DataFormatter dataFormatter = new DataFormatter();
				FileInputStream fileInputStream = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
				// Get first sheet
				XSSFSheet sheet = workbook.getSheetAt(0);
				if (sheet != null && sheet.getLastRowNum() > 0) {
					List<Login> loginDataList = new ArrayList<Login>();
					// Because first row is header, i index will start at 1
					for (int i = 1; i <= sheet.getLastRowNum(); i++) {

						Row row = sheet.getRow(i);
						if (row != null && row.getLastCellNum() > 0) {
							Login login = new Login();
							// Cell 0: code
							Cell cell = row.getCell(0);
							login.setEmail(Objects.isNull(cell) ? "" : dataFormatter.formatCellValue(cell));

							// Cell 1: fullname
							cell = row.getCell(1);
							login.setPassword(Objects.isNull(cell) ? "" : dataFormatter.formatCellValue(cell));

							cell = row.getCell(2);
							login.setMessageResult(Objects.isNull(cell) ? "" : dataFormatter.formatCellValue(cell));

							loginDataList.add(login);
						}
					}
					// Note: You have to close workbook.
					workbook.close();
					return loginDataList;
				}
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}