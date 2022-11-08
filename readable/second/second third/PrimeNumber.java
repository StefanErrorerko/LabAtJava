package Lab1;

import java.util.ArrayList;

public class PrimeNumber {

	public static ArrayList<Integer> simpleArrayCreator(int n) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			numbers.add(i);
		}
		return numbers;
	}

	public static ArrayList<Integer> primeNumberFinder(ArrayList<Integer> allNumberArr) {

		ArrayList<Integer> simpleNumbersArr = new ArrayList<Integer>();

		if (allNumberArr.size() <= 10) {
			// in progress
		}

		else {
			simpleNumbersArr.add(2);
			simpleNumbersArr.add(3);
			simpleNumbersArr.add(5);
			simpleNumbersArr.add(7);
			for (int i = 0; i < allNumberArr.size(); i++) {

				if (allNumberArr.get(i) % 2 != 0 &
						allNumberArr.get(i) % 3 != 0 &
						allNumberArr.get(i) % 5 != 0 &
						allNumberArr.get(i) % 7 != 0) {
					simpleNumbersArr.add(allNumberArr.get(i));
				}
				simpleNumbersArr.remove(Integer.valueOf(1));
			}
		}
		return simpleNumbersArr;
	}
}
