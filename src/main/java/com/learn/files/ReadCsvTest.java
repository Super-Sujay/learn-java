package com.learn.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadCsvTest {

	public static void main(String[] args) {
		List<Map<String, String>> data = getCsvData("./src/main/resources/annual-enterprise-survey.csv",
				"2011");
		data.forEach(map -> {
			System.out.println("--------New Data--------------");
			map.forEach((k, v) -> System.out.println(k + "=" + v));
		});
		System.out.println(data.size());
	}

	private static List<Map<String, String>> getCsvData(String pathName, String testCaseName) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			String[] keys = Files.lines(Paths.get(pathName))
					.findFirst()
					.orElseThrow(IOException::new)
					.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			List<String[]> dataArray = Files.lines(Paths.get(pathName))
				.filter(line -> line.startsWith(testCaseName))
				.map(line -> line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"))
				.collect(Collectors.toList());
			for (String[] values : dataArray) {
				Map<String, String> testData = new HashMap<String, String>();
				for (int i = 1; i < keys.length; i++)
					if (!values[i].isEmpty())
						testData.put(keys[i], values[i]);
				list.add(testData);
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathName + " file.\n" + e.getStackTrace().toString());
		}
		return list;
	}

}
