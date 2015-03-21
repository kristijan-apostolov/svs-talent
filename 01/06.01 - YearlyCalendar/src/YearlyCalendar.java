
public class YearlyCalendar {

	public static void main(String[] args) {

		String[] myStringArray;
		int counter = 0;
		int year = 2016;

		if (ifLeap(year)) {
			myStringArray = new String[366];
		} else {
			myStringArray = new String[365];
		}

		for (int i = 1; i < 13; i++) {
			int days = countDays(i, year);

			for (int j = 1; j <= days; j++) {
				String pom = "Date: " + j + "/" + i + "/" + year;

				myStringArray[counter] = pom;

				counter++;
			}
		}

		printMyStringArray(myStringArray);

	}

	public static boolean ifLeap(int year) {
		if (year % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void printMyStringArray(String[] myStringArray) {
		for (int k = 0; k < myStringArray.length; k++) {
			System.out.println(myStringArray[k]);
		}
	}

	public static int countDays(int month, int year) {
		int count = -1;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			count = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			count = 30;
			break;
		case 2:
			if (year % 4 == 0) {
				count = 29;
			} else {
				count = 28;
			}
			if ((year % 100 == 0) & (year % 400 != 0)) {
				count = 28;
			}
		}
		return count;
	}

}
