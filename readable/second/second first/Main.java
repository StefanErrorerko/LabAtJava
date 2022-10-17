package Lab1;
import java.util.ArrayList;

/*6.Серед простих чисел, які не перевищують заданий n, знайти таке,
в двійковій формі якого максимальна кількість одиниць.
Просте число – це натуральне число, яке ділиться на 1 та на себе.
*/

public class Main {
	public static void main (String[] args) {
		
		taskSix(250);//n
	}
	
	
	public static void taskSix(int n) {
		//Step 1
		//array of all number that bigger than 0 and less than n 
		ArrayList<Integer> numbers = PrimeNumber.simpleArrayCreator(n);
		//Step 2
		//array of all prime numbers that less than n
		ArrayList<Integer> primeNumbers = PrimeNumber.primeNumberFinder(numbers);
		//Step 3
		//an array is a sum of 1's of the binary form of a number
		Integer[] summ1binary = BinaryMaxFinder.summedOnesArr(primeNumbers);
		//Step 4
		//array of indexes of the max numbers from prime numbers array
		ArrayList<Integer> maxIndexes = BinaryMaxFinder.findMax(summ1binary);
		//Step 5
		//taking numbers from prime number array by maxIndexes
		ArrayList<Integer> finalArray = BinaryMaxFinder.findMaxOnes(maxIndexes, primeNumbers);
		
		//sout
		System.out.println("All prime numbers:  ");
		for(int i=0; i<primeNumbers.size(); i++) {
			System.out.print(primeNumbers.get(i) + " ");
		}
		System.out.println("\n"+"Sum of 1's of the binary form:  ");
		for(int i=0; i<summ1binary.length; i++) {
			System.out.print(summ1binary[i] + " ");
		}
		System.out.println("\n"+"Indexes of the max numbers:  ");
		for(int i=0; i<maxIndexes.size(); i++) {
			System.out.print(maxIndexes.get(i) + " ");
		}
		System.out.println("\n"+"Number with max number of 1`s:  ");
		for(int i=0; i<finalArray.size(); i++) {
			System.out.print(finalArray.get(i) + " ");
		}
	}
}
