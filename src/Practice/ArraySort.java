package Practice;

import java.util.*;

public class ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] arrA = { 2, 4, 5, 7, 8 };
		
		System.out.println("Original Elements of Array A:");
		printArr(arrA);
		
		int repIndex = 2;

		int replvalue = 10;

		arrA[repIndex] = replvalue;
		System.out.println("After replacing one Element of Array A:");
		
		printArr(arrA);

		Integer[] arrB = new Integer[arrA.length];

		arrB = Arrays.copyOf(arrA, arrA.length);
		Arrays.sort(arrB, Collections.reverseOrder());
		
		System.out.println("Elements of Array B in descending order:");
		printArr(arrB);

	}

	public static void printArr(Integer[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			System.out.print(" ");
		}
		System.out.println();
	}

}
