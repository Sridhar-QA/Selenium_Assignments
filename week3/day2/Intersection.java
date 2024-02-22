package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {

	public static List<Integer> findIntersectionBaseApproach(int[] arr1, int[] arr2) {
		List<Integer> arrList1 = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();

		// convert arr1 to list
		for(int i=0; i<arr1.length; i++) {
			arrList1.add(arr1[i]);
		}

		// iterate both the array and list and if the element is present in both print the element
		for(int i = 0; i< arr2.length; i++) {
			for(int j = 0; j<arrList1.size(); j++) {
				if((arr2[i] == arrList1.get(j))) {
					result.add(arr2[i]);

					// remove the element to avoid checking same element multiple times
					arrList1.remove(j);
				}
			}
		}
		return result;
	}

	public static List<Integer> findIntersectionUsingRetainAll(int[] arr1, int[] arr2) {
		Set<Integer>set1 = new HashSet<Integer>();
		Set<Integer>set2 = new HashSet<Integer>();
		for(int i=0; i<arr1.length; i++) {
			set1.add(arr1[i]);
		}

		for(int i=0; i<arr2.length; i++) {
			set2.add(arr2[i]);
		}

		set1.retainAll(set2);
		List<Integer> result = new ArrayList<Integer>(set1);
		return result;
	}
	public static void main(String[] args) {
		int[] arr1 = {3, 2, 11, 4, 6, 7};
		int[] arr2 = {1, 2, 8, 4, 9, 7};

		// Approach 1 - considering array doesnt have duplicates
		System.out.println("Find intersection base approach: "+findIntersectionBaseApproach(arr1, arr2));


		// approach 2
		System.out.println("Find intersection using set retainAll method: " +findIntersectionUsingRetainAll(arr1, arr2));
	}

}
