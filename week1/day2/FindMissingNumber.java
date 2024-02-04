package week1.day2;

public class FindMissingNumber {
	
	public int missingNumber(int[] numberArray, int originalLength) {
		
		int totalSum = (originalLength * (originalLength+1)) / 2;
		for(int i = 0; i< numberArray.length; i++) {
			totalSum-=numberArray[i];
		}
		return totalSum;
	}
	
	public int missingNumberOptimized(int[] numberArray, int originalLength) {
		int result1 = numberArray[0];
		
		// bitwise xor result for given array
		for(int i = 1; i< numberArray.length; i++) {
			result1 = result1 ^ numberArray[i];
		}
		
		// bitwise xor result for the original length
		int result2 = 1;
		for(int i = 2; i <=originalLength; i++) {
			result2 = result2 ^ i;
		}
		
		return result1 ^ result2;
	}

	public static void main(String[] args) {
		int[] numberArray = {1,4,3,2,8,6,7};
		int lengthOfArray = numberArray.length;
		int originalLength = lengthOfArray + 1;
		FindMissingNumber obj = new FindMissingNumber();
		System.out.println(obj.missingNumber(numberArray, originalLength));
		System.out.println("<-----Optimized Solution ---->");
		System.out.println(obj.missingNumberOptimized(numberArray, originalLength));
	}

}
