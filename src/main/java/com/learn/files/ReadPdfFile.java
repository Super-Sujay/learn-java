package com.learn.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.testng.Assert;

public class ReadPdfFile {

	public static void main1(String[] args) throws IOException {

		PDDocument document = PDDocument.load(new File("./src/test/resources/Half Girlfriend.pdf"));
		document.getClass();
		if (!document.isEncrypted()) {
			PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			stripper.setSortByPosition(true);

			PDFTextStripper tStripper = new PDFTextStripper();
			String pdfFileInText = tStripper.getText(document);

			String lines[] = pdfFileInText.split("\\r?\\n");
			for (String line : lines)
				System.out.println(line);
		}

	}
	
	public static void main2(String[] args) throws IOException {
		URL url1 = new URL("http://www.africau.edu/images/default/sample.pdf");
		FileOutputStream fos1 = new FileOutputStream("download.pdf");
		byte[] ba1 = new byte[1024];
		int baLength;
		System.out.println("Connecting to " + url1.toString() + " ... ");
		URLConnection urlConn = url1.openConnection();
		
		if(!urlConn.getContentType().equalsIgnoreCase("application/pdf")) {
			System.out.println("FAILED.\n[Sorry. This is not a PDF.]");
		} else {
			InputStream is1 = url1.openStream();
			while((baLength = is1.read(ba1)) != -1) {
				fos1.write(ba1, 0, baLength);
			}
			fos1.flush();
			fos1.close();
			is1.close();
			
			System.out.println("DONE.\nProcessing the PDF ... ");
			PDDocument document = PDDocument.load(new File("download.pdf"));
			if (!document.isEncrypted()) {
				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);

				PDFTextStripper tStripper = new PDFTextStripper();
				String pdfFileInText = tStripper.getText(document);

				String lines[] = pdfFileInText.split("\\r?\\n");
				for (String line : lines)
					System.out.println(line);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		String pdfData = readPdfFromUrl2("http://www.africau.edu/images/default/sample.pdf");
		System.out.println(pdfData.replaceAll("\\r\\n", ""));
		System.out.println("----------------------------------------------------------------------------");
		Assert.assertTrue(pdfData.replaceAll("\\r\\n", "").contains("Simple PDF File 2  ...continued from page 1."), "PDF data incorrect");
//		pdfData = readPdfFromUrl("https://www.axmag.com/download/pdfurl-guide.pdf");
//		System.out.println(pdfData);
	}
	
	public static String readPdfFromUrl(String url) throws Exception {
		String pdfFileInText = "This URL does not contain PDF.";
		URL url1 = new URL(url);
		System.out.println("Connecting to " + url1.toString() + " ... ");
		URLConnection urlConn = url1.openConnection();
		if(!urlConn.getContentType().equalsIgnoreCase("application/pdf")) {
			System.out.println("FAILED.\n[Sorry. This is not a PDF.]");
		} else {
			FileOutputStream fos1 = new FileOutputStream("download.pdf");
			InputStream is1 = url1.openStream();
			byte[] ba1 = new byte[1024];
			int baLength;
			while((baLength = is1.read(ba1)) != -1)
				fos1.write(ba1, 0, baLength);
			fos1.flush();
			fos1.close();
			is1.close();
			System.out.println("DONE.\nProcessing the PDF ... ");
			PDDocument document = PDDocument.load(new File("download.pdf"));
			if (!document.isEncrypted()) {
				PDFTextStripper tStripper = new PDFTextStripper();
				pdfFileInText = tStripper.getText(document);
			}
			document.close();
			Files.deleteIfExists(Paths.get("./download.pdf"));
		}
		return pdfFileInText;
	}
	
	public static String readPdfFromUrl1(String url) throws Exception {
		String pdfFileInText = "This URL does not contain PDF.";
		URL url1 = new URL(url);
		System.out.println("Connecting to " + url1.toString() + " ... ");
		URLConnection urlConn = url1.openConnection();
		if(!urlConn.getContentType().equalsIgnoreCase("application/pdf")) {
			System.out.println("FAILED.\n[Sorry. This is not a PDF.]");
		} else {
			System.out.println("DONE.\nProcessing the PDF ... ");
			PDDocument document = PDDocument.load(url1.openStream());
			if (!document.isEncrypted()) {
				pdfFileInText = new PDFTextStripper().getText(document);
			}
			document.close();
		}
		return pdfFileInText;
	}
	
	public static String readPdfFromUrl2(String url) throws Exception {
		String pdfFileInText = "This URL does not contain PDF.";
		URL url1 = new URL(url);
		System.out.println("Connecting to " + url1.toString() + " ... ");
		URLConnection urlConn = url1.openConnection();
		if(!urlConn.getContentType().equalsIgnoreCase("application/pdf")) {
			System.out.println("FAILED.\n[Sorry. This is not a PDF.]");
		} else {
			System.out.println("DONE.\nProcessing the PDF ... ");
			PDDocument document = PDDocument.load(url1.openStream());
			if (!document.isEncrypted()) {
				pdfFileInText = new PDFTextStripper().getText(document);
			}
			document.close();
		}
		return pdfFileInText;
	}

}
