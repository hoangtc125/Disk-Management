package hust.soict.globalict.test.utils;

import java.util.Scanner;
import hust.soict.globalict.aims.utils.DateUtils;
import hust.soict.globalict.aims.utils.MyDate;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate today = new MyDate();
//		today.print();
		MyDate date = new MyDate("March 19st 2021");
		MyDate date2 = new MyDate("February 22st 2021");
		date.print();
		date2.print();
		System.out.println();
		System.out.println("compare two dates:");
		if(DateUtils.compareTwoDates(date, date2) == 1) {
			System.out.println(date.toString() + " > " + date2.toString());
		} else if(DateUtils.compareTwoDates(date, date2) == 2) {
			System.out.println(date.toString() + " < " + date2.toString());
		} else if(DateUtils.compareTwoDates(date, date2) == 0) {
			System.out.println(date.toString() + " = " + date2.toString());
		}
		System.out.println();
		MyDate [] dates = new MyDate[4];
		dates[0] = new MyDate("February 19st 2021");
		dates[1] = new MyDate("March 19st 2021");
		dates[2] = new MyDate("February 22st 2021");
		dates[3] = new MyDate("February 13st 2021");
		System.out.println("sorting dates[]:");
		for (MyDate tmp : dates) {
			System.out.println(tmp.toString());
		}
		System.out.println();
		System.out.println("before:");	
		DateUtils.sorting(dates);
		System.out.println("Format Example\r\n" + 
				"1     yyyy-MM-dd 1930-02-03\r\n" + 
				"2     d/M/yyyy 3/2/1930\r\n" + 
				"3     dd-MMM-yyyy 03-Feb-1930\r\n" + 
				"4     MMM d yyyy Feb 3 1930\r\n" + 
				"5     mm-dd-yyyy 02-03-1930\n" +
				"0     Exit");
		System.out.print("choose the number to show your format day: ");
		Scanner scanner = new Scanner(System.in);
		switch (scanner.nextInt()) {
		case 1:
			System.out.print(today.getYear() + "-");
			if(today.monthNumber() < 10) {
				System.out.print("0" + today.monthNumber());
			} else {
				System.out.print(today.monthNumber());
			}
			if(today.getDay() < 10) {
				System.out.print("-0" + today.getDay());
			} else {
				System.out.print("-" + today.getDay());
			}
			break;
		case 2:
			if(today.getDay() < 10) {
				System.out.print("0" + today.getDay() + "/");
			} else {
				System.out.print(today.getDay() + "/");
			}
			if(today.monthNumber() < 10) {
				System.out.print("0" + today.monthNumber() + "/");
			} else {
				System.out.print(today.monthNumber() + "/");
			}
			System.out.print(today.getYear());
			break;
		case 3:
			if(today.getDay() < 10) {
				System.out.print("0" + today.getDay() + "-");
			} else {
				System.out.print(today.getDay() + "-");
			}
			System.out.print(today.getMonth().substring(0, 3));
			System.out.print("-" + today.getYear());
			break;
		case 4:
			System.out.print(today.getMonth().substring(0, 3) + " ");
			if(today.getDay() < 10) {
				System.out.print("0" + today.getDay() + "");
			} else {
				System.out.print(today.getDay() + " ");
			}
			System.out.print(today.getYear());
			break;
		case 5:
			if(today.monthNumber() < 10) {
				System.out.print("0" + today.monthNumber());
			} else {
				System.out.print(today.monthNumber());
			}
			if(today.getDay() < 10) {
				System.out.print("-0" + today.getDay());
			} else {
				System.out.print("-" + today.getDay());
			}
			System.out.print("-" + today.getYear());
			break;
		case 0:
			System.out.println("thanks for using");
			break;

		default:
			System.out.println("End");
			break;
		}
	}

}
