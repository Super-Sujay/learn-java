package com.learn.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeAPI {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		System.out.println("Current Date: " + today);

		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date: " + firstDay_2014);

		LocalDate todayNewYork = LocalDate.now(ZoneId.of("America/New_York"));
		System.out.println("Current Date in New York: " + todayNewYork);

		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println("365th day from base date: " + dateFromBase);

		LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
		System.out.println("100th day of 2014: " + hundredDay2014);

		LocalTime time = LocalTime.now();
		System.out.println("Current Time: " + time);

		LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
		System.out.println("Specific Time of Day: " + specificTime);

		LocalTime timeNewYork = LocalTime.now(ZoneId.of("America/New_York"));
		System.out.println("Current Time in New York: " + timeNewYork);

		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
		System.out.println("10000th second time: " + specificSecondTime);

		LocalDateTime todayDT = LocalDateTime.now();
		System.out.println("Current Date Time: " + todayDT);
		
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");
		System.out.println("Date in a pattern: " + todayDT.format(datePattern));

		todayDT = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Current Date Time: " + todayDT);

		LocalDateTime specificDateTime = LocalDateTime.of(2014, Month.DECEMBER, 1, 10, 20, 30, 40);
		System.out.println("Specific Date Time: " + specificDateTime);

		LocalDateTime todayNewYorkDateTime = LocalDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("Current Date Time in New York: " + todayNewYorkDateTime);

		LocalDateTime dateTimeFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
		System.out.println("10000th second time from 01/01/1970: " + dateTimeFromBase);

		Instant timeStamp = Instant.now();
		System.out.println("Current Timestamp: " + timeStamp);

		Instant specificInstantTime = Instant.ofEpochMilli(timeStamp.toEpochMilli());
		System.out.println("Specific Time: " + specificInstantTime);

		Duration thirtyDay = Duration.ofDays(30);
		System.out.println("Duration of 30 days: " + thirtyDay);

		System.out.println("Year " + today.getYear() + " is Leap Year? " + today.isLeapYear());

		System.out.println("Today is before 01/01/2015? " + today.isBefore(LocalDate.of(2015, 1, 1)));

		// Date to Instant
		Instant timestamp = new Date().toInstant();

		// Convert Instant to LocalDateTime
		LocalDateTime date = LocalDateTime.ofInstant(timestamp, ZoneId.of(ZoneId.SHORT_IDS.get("IST")));
		System.out.println("Date: " + date);
		
		// Calendar to Instant
		Instant time1 = Calendar.getInstance().toInstant();
		System.out.println("Time: " + time1);

		// Timezone to ZoneId
		ZoneId defaultZone = TimeZone.getDefault().toZoneId();
		System.out.println("Default Zone: " + defaultZone);

		// ZonedDateTime from specific Calender
		ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
		System.out.println("Gergorian Calendar Date Time: " + gregorianCalendarDateTime);

		// Date API to Legacy classes
		Date dt = Date.from(Instant.now());
		System.out.println("Date from Legacy Class: " + dt);

		TimeZone tz = TimeZone.getTimeZone(defaultZone);
		System.out.println("Time Zone: " + tz);

		GregorianCalendar gc = GregorianCalendar.from(gregorianCalendarDateTime);
		System.out.println("Gregorian Calendar Date Time: " + gc);

		System.out.println("All the zones:");
		ZoneId.SHORT_IDS.forEach((k, v) -> System.out.println("Key: " + k + "\tValue: " + v));

	}

}
