package hust.soict.globalict.aims.utils;

public class DateUtils {
	public static int compareTwoDates(MyDate date1, MyDate date2) {
		if(date1.getYear() > date2.getYear()) {
			return 1;
		} else if(date1.getYear() < date2.getYear()) {
			return 2;
		} else {
			if(date1.monthNumber() > date2.monthNumber()) {
				return 1;
			} else if(date1.monthNumber() < date2.monthNumber()) {
				return 2;
			} else {
				if(date1.getDay() > date2.getDay()) {
					return 1;
				} else if(date1.getDay() < date2.getDay()) {
					return 2;
				} else {
					return 0;
				}
			}
		}
	}
	
	public static void sorting(MyDate [] dates) {
		for(int i = 0; i < dates.length - 1; i++) {
			for(int j = dates.length - 1; j >= i + 1; j--) {
				if(compareTwoDates(dates[j - 1], dates[j]) == 1) {
					MyDate tmpDate = dates[j - 1];
					dates[j - 1] = dates[j];
					dates[j] = tmpDate; 
				}
			}
		}
		for (MyDate tmp : dates) {
			System.out.println(tmp.toString());
		}
	}
}
