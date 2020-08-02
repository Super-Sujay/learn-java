package com.learn.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class StringManupulator {

	public static void main(String[] args) {
		
		InputStream in = System.in;
		Reader reader = new InputStreamReader(in);
		BufferedReader buffreader = new BufferedReader(reader);
		String s = "";
		System.out.println("Enter the sentence.");
		try {
			s = buffreader.readLine();
		} catch (IOException e) {
			System.out.println("IOException occured.");
		}
		if(s.isEmpty())
			System.out.print("You did not enter anything.");
		else {
			System.out.println("The individual words in the sentence are");
			for(String str : s.split("\\s"))
				System.out.print(str + ":");
		}
		
	}

}
