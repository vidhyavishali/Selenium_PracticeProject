package week3.day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionSet {

	public static void main(String[] args) {
		Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(3, 2, 11, 4, 6, 7));
		Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(1, 2, 8, 4, 9, 7));
		System.out.println("Intersecting numbers are..");
		for (Integer i1 : s1)
			for (Integer i2 : s2)
				if (i1 == i2)
					System.out.print(i1 + ",");

	}

}
