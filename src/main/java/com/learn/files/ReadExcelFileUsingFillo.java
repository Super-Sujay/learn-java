package com.learn.files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadExcelFileUsingFillo {

	public static void main1(String[] args) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Connection con = null;
		Recordset record = null;
		try {
			Fillo fillo = new Fillo();
			con = fillo.getConnection("./src/main/resources/Sales Records.xlsx");
			record = con.executeQuery("Select * from Sales where Region = 'Europe'");
			while (record.next()) {
				Map<String, String> data = new HashMap<>();
				for (String str : record.getFieldNames())
					if (!record.getField(str).isEmpty())
						data.put(str, record.getField(str));
				list.add(data);
			}
			con.executeUpdate("Update Sales Set Result = 'Success' where Region = 'Europe'");
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			System.out.println("----------------------------");
			list.forEach(map -> {
				map.forEach((k, v) -> System.out.println(k + " = " + v));
				System.out.println("----------------------------");
			});
			record.close();
			con.close();
		}
	}

	public static void main(String[] args) {
		Map<String, String> testData = getExcelData("./src/main/resources/Sales Records.xlsx", "Sales1", "Sujay");
		testData.forEach((k, v) -> System.out.println(k + " = " + v));
	}

	public static Map<String, String> getExcelData(String filePath, String sheetName, String testCase) {
		Connection con = null;
		Recordset record = null;
		try {
			Fillo fillo = new Fillo();
			con = fillo.getConnection(filePath);
			record = con.executeQuery("Select * from " + sheetName + " where TestCase = '" + testCase + "'");
			Map<String, String> data = new HashMap<>();
			while (record.next())
				for (String str : record.getFieldNames())
					if (!record.getField(str).isEmpty())
						data.put(str, record.getField(str));
			return data;
		} catch (FilloException e) {
			throw new RuntimeException("Unable to get data from Excel", e);
		} finally {
			record.close();
			con.close();
		}
	}

}
