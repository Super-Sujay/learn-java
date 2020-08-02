package com.learn.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ReadCsvFiles {

	public static void main(String[] args) {
		// List<Map<String, String>> list = new ArrayList<Map<String,
		// String>>();
		// list =
		// getCsvData("./src/main/resources/annual-enterprise-survey.csv");
		// list.forEach(map -> map.forEach((k, v) -> System.out.println(k + "="
		// + v)));
		// list.get(0).forEach((k, v) -> System.out.println(k + "=" + v));
		// printCsvData("./src/main/resources/annual-enterprise-survey.csv");
		System.out.println(search("./src/main/resources/annual-enterprise-survey.csv", "All Industries"));
		System.out.println("CSV Data for header [value] for row number [183] is "
				+ getValueFromCsv("./src/main/resources/annual-enterprise-survey.csv", "value", 183));
	}

	private static List<Map<String, String>> getCsvData(String pathName) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			String data = Files.lines(Paths.get(pathName)).collect(Collectors.joining("\n"));
			String[] dataParts = data.split("\n");
			String[] keys = dataParts[0].split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			for (int i = 1; i < dataParts.length; i++) {
				Map<String, String> testData = new HashMap<String, String>();
				String values[] = dataParts[i].split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				for (int j = 0; j < keys.length; j++)
					testData.put(keys[j], values[j]);
				list.add(testData);
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathName + " file.\n" + e.getStackTrace().toString());
		}
		return list;
	}

	private static String getValueFromCsv(String file, String header, int lineNumber) {
		try {
			return getCsvData(file).get(lineNumber - 2).get(header);
		} catch (IndexOutOfBoundsException e) {
			return "null";
		}
	}

	public static String search1(String file, String value) {
		List<Map<String, String>> list = getCsvData(file);
		for (int i = 0; i < list.size(); i++) {
			for (Entry<String, String> data : list.get(i).entrySet()) {
				if (data.getValue().contains(value)) {
					return "Value found at row [" + (i + 2) + "] in column [" + data.getKey() + "]";
				}
			}
		}
		return "Value not found";
	}

	private static String search(String file, String value) {
		StringJoiner sj = new StringJoiner("\n");
		sj.setEmptyValue("Value not found");
		List<Map<String, String>> list = getCsvData(file);
		Map<Integer, String> result = new HashMap<Integer, String>();
		for (int i = 0; i < list.size(); i++)
			for (Entry<String, String> data : list.get(i).entrySet())
				if (data.getValue().contains(value))
					result.put(i, data.getKey());
		for (Map.Entry<Integer, String> data : result.entrySet())
			sj.add("Value found at row [" + (data.getKey() + 2) + "] in column [" + data.getValue() + "]");
		return sj.toString();
	}

	public static void printCsvData(String file) {
		getCsvData(file).forEach(map -> map.forEach((k, v) -> System.out.println(k + "=" + v)));
	}

}