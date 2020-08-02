package com.learn.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeManupulation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getMonth() + 1);
		System.out.println(date.getYear() + 1900);
		System.out.println(date.getDay());
		System.out.println(date.getHours());
		convertDate2("Thu 15/08/2019");
		
	}
	
	public static void convertDate(String date) {
		System.out.println("The given date is: " + date);
		DateTimeFormatter originalFormat = DateTimeFormatter.ofPattern("EEE dd/MM/yyyy");
		DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localdate = LocalDate.parse(date, originalFormat);
		System.out.println("The new format date is: " + newFormat.format(localdate));
	}
	
	private static void convertDate2(String date) {
		System.out.println("The given date is: " + date);
		System.out.println("The new format date is: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.parse(date, DateTimeFormatter.ofPattern("EEE dd/MM/yyyy"))));
	}
}
