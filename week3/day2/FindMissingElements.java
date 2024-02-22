package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMissingElements {

	public static void main(String[] args) { 
		int[] arr1= {1, 2, 3, 4, 10, 6, 8};
		int[] arr = {2,6};
		
		Arrays.sort(arr);
		if(arr.length < 2) {
			System.out.println("Invalid input");
		}else {
			int i = 0;
			
			// loop through the length of the array
			while(i < arr.length-1) {
				// if current element + 1 is not the next element then print all the elements between current element and next element
				if(arr[i]+1 != arr[i+1]) {
					int j = arr[i];
					while(j < arr[i+1]-1) { 
						j++; // 3,4,5
						System.out.println(j);
					}
				}
				// move to next index
				i++;
			}
		}
	}
}
