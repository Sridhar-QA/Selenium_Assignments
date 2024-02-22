package week3.day2;

public class FindSecondLargestNumber {

	public static void main(String[] args) {
		int[] arr = {3, 2, 11, 4, 6, 7};
		int firstMax = arr[0];
		int secondMax = arr[0];
		
		// Approach 1
		for(int i=1; i<arr.length; i++) {
			
			// traverse the array and update the first max
			if(arr[i] > firstMax) {
				firstMax = arr[i];
			}
			
			// update second max when the number if not equal to firstMax and it is greater than second max
			else if (arr[i] != firstMax && (arr[i] > secondMax) ) {
				secondMax = arr[i];
			}
		}
		
		System.out.println("first maximum: "+firstMax);
		System.out.println("second maximum: "+secondMax);
		
		// Approach 2: Convert array to list and Sort the list and reverse it using inbuilt method in collections. Take second element from the list 

	}

}
