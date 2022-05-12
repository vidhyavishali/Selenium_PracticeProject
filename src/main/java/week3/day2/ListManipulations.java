package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListManipulations {

	public static void main(String[] args) {

		int[] data = { 3, 2, 11, 4, 6, 7 };

		/** 1. Find second largest number from the array */

		/*
		 * convert the array to list. sort them, and get the second index from last of
		 * the list
		 */
		List<Integer> dataList = convertToList(data);

		Collections.sort(dataList);
		System.out.println("The second largest number from the list is :" + dataList.get(dataList.size() - 2));

		/** 2. Find the missing element */

		/*
		 * convert the array to list. sort them, compare the position of the number in
		 * list, to the number itself. If it doesnt match, break the loop and print the
		 * index number.
		 */
		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };
		System.out.print("Missing element is :");
		List<Integer> arrList = convertToList(arr);
		Collections.sort(arrList);
		for (int i = 0; i < arrList.size(); i++) {
			int j = i + 1;

			if (j != arrList.get(i)) {
				System.out.println(j);
				break;
			}
		}

		/** 3. Print duplicates in list */
		List<Integer> dupList = new ArrayList<Integer>(
				Arrays.asList(14, 12, 13, 11, 15, 14, 18, 16, 17, 19, 18, 17, 20));
	

		System.out.println("Duplicate values are: ");
		for (int i = 0; i < dupList.size(); i++) {
			Integer c = dupList.get(i);
			dupList.set(i, -1);
			if (dupList.contains(c)) {
				System.out.print(c + ", ");
			}
		}

	}

	private static List<Integer> convertToList(int[] data) {
		List<Integer> dataList = new ArrayList<Integer>();

		for (int i = 0; i < data.length; i++) {
			dataList.add(data[i]);
		}
		return dataList;
	}
}
