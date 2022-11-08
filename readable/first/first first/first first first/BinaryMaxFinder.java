package Lab1;
import java.util.ArrayList;

public class BinaryMaxFinder {
	
	public static int toBinarySum(int decimal) {
		 String binary = Integer.toBinaryString(decimal);
		 String[] words = binary.split("");
		 //System.out.println(Arrays.toString(words));
		 int[] numbers = new int[words.length];
		 
		 //parse String Array to Integer array
		 for (int i =0; i < words.length; i++) {
			 numbers[i] = Integer.parseInt(words[i]);
		 }
		 
		 //sum all 1 in array
		 int sum = 0;
		    for (int i = 0; i < numbers.length; i++) {
		        sum = sum + numbers[i];
		    }
		 return sum;
	}
	
	public static Integer[] summedOnesArr(ArrayList<Integer> simpleNumbersArr) {
		Integer[] summ1binary = new Integer[simpleNumbersArr.size()];
			
		for(int i=0; i < simpleNumbersArr.size(); i++) {
			summ1binary[i] = toBinarySum(simpleNumbersArr.get(i));
		}
		return summ1binary;
	}
	
	public static ArrayList<Integer> findMax(Integer[] array) {
		ArrayList<Integer> maxIndexes = new ArrayList<Integer>();
		
		//find max
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		//find all max numbers
		for (int i = 0; i < array.length; i++) {
			if(max == array[i]) {
				maxIndexes.add(i);
			}
		}
		return maxIndexes;
	} 
	
	public static ArrayList<Integer> findMaxOnes(
			ArrayList<Integer> maxIndexes,
			ArrayList<Integer> simpleNumbersArr )
	{
		ArrayList<Integer> finalArray = new ArrayList<Integer>();
		
		for (int i=0; i < maxIndexes.size(); i++) {
		finalArray.add(simpleNumbersArr.get(maxIndexes.get(i)));
		}
		
		return finalArray;
	}
}
