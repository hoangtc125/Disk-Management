package hust.soict.globalict.aims.utils;

import java.util.Scanner;

public class MyDate {
	private int day;
	private String month;
	private int year;
	
	public MyDate() {
		super();
		this.day = 17;
		this.month = "March";
		this.year = 2021;
	}
	public MyDate(String s) {
		super();
		String [] tmp = s.split(" ");
		fixDay(tmp[1]);
		fixMonth(tmp[0]);
		fixYear(tmp[2]);
	}
	public MyDate(int day, String month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public MyDate(String day, String month, String year) {
		super();
		switch (day) {
		case "firsth":
			setDay(1);
			break;
		case "second":
			setDay(2);
			break;
		case "third":
			setDay(3);
			break;
		case "fourth":
			setDay(4);
			break;
		case "fifth":
			setDay(5);
			break;
		case "sixth":
			setDay(6);
			break;
		case "seventh":
			setDay(7);
			break;
		case "eighth":
			setDay(8);
			break;
		case "ninth":
			setDay(9);
			break;
		case "tenth":
			setDay(10);
			break;
		case "eleventh":
			setDay(11);
			break;
		case "twelveth":
			setDay(12);
			break;
		case "thirteenth":
			setDay(13);
			break;
		case "fourteenth":
			setDay(14);
			break;
		case "fifteenth":
			setDay(15);
			break;
		case "sixteenth":
			setDay(16);
			break;
		case "seventeenth":
			setDay(17);
			break;
		case "eightteenth":
			setDay(18);
			break;
		case "nineteenth":
			setDay(19);
			break;
		case "twentieth":
			setDay(20);
			break;
		case "twenty firsth":
			setDay(21);
			break;

		default:
			break;
		}
	}

	public int monthNumber() {
		if(getMonth().compareTo("January") == 0) return 1;
		if(getMonth().compareTo("February") == 0) return 2;
		if(getMonth().compareTo("March") == 0) return 3;
		if(getMonth().compareTo("April") == 0) return 4;
		if(getMonth().compareTo("May") == 0) return 5;
		if(getMonth().compareTo("June") == 0) return 6;
		if(getMonth().compareTo("July") == 0) return 7;
		if(getMonth().compareTo("August") == 0) return 8;
		if(getMonth().compareTo("September") == 0) return 9;
		if(getMonth().compareTo("October") == 0) return 10;
		if(getMonth().compareTo("November") == 0) return 11;
		if(getMonth().compareTo("December") == 0) return 12;
		return -1;
	}
	
	void fixDay(String s) {
		s = s.substring(0, s.length() - 2);
		setDay(Integer.valueOf(s));
	}
	void fixMonth(String s) {
		setMonth(s);
	}
	void fixYear(String s) { 
		setYear(Integer.valueOf(s));
	}
	 
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void accept() {
		System.out.println("Enter a date (String) from keyboard");
		Scanner key = new Scanner(System.in);
		String s = key.nextLine();
		String [] tmp = s.split(" ");
		fixDay(tmp[1]);
		fixMonth(tmp[0]);
		fixYear(tmp[2]);
	 }
	
	public void print() {
		System.out.println("Current date: ");
		System.out.print(getMonth() + " " + getDay() + " " + getYear());
		System.out.println();
	}
	
	public String toString() {
		return month + " " + day + " " + year;
	}
}
