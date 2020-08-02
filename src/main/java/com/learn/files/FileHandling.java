package com.learn.files;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class FileHandling {

	public static void main1(String[] args) throws IOException {

		Path path = Paths.get(System.getProperty("user.dir") + "/KCD_doc_PCR.docx");
		InputStream is = Files.newInputStream(path);
		XWPFDocument document = new XWPFDocument(is);
		XWPFWordExtractor extractor = new XWPFWordExtractor(document);
		StringJoiner wordData = new StringJoiner(" ");
		List<String> data = Arrays.asList(extractor.getText());
		data.forEach(wordData::add);
		extractor.close();
		System.out.println(wordData);
		if (wordData.toString().contains("PCR uses Lucene Search Engine for the faster search retrieval."))
			System.out.println("Text is present in the document");
		else
			System.out.println("Text is not present in the document");

	}
	
	public static void main(String[] args) {

		Path path = Paths.get(System.getProperty("user.dir") + "/src/main/resources/KCD_doc_PCR.docx");
		String wordData;
		try {
			InputStream is = Files.newInputStream(path);
			XWPFDocument document = new XWPFDocument(is);
			is.close();
			XWPFWordExtractor extractor = new XWPFWordExtractor(document);
			document.close();
			wordData = extractor.getText();
			extractor.close();
		} catch (IOException e) {
			wordData = e.getMessage();
		}
		System.out.println(wordData);
		if (wordData.contains("PCR uses Lucene Search Engine for the faster search retrieval."))
			System.out.println("Text is present in the document");
		else
			System.out.println("Text is not present in the document");

	}
	
	public static void main3(String[] args) throws IOException {
		Path source = Paths.get(System.getProperty("user.dir") + "/Temp.txt");
		Path target = Paths.get(System.getProperty("user.dir") + "/TempCopied.txt");
		Files.copy(source, target);
	}

}
