package week1.day2;

public class FindIntersection {

	public static void main(String[] args) {
		int[] array1 = {3,2,11,4,6,7};
		int[] array2 = {1,2,8,4,9,7};
		
		//approach1 ->  Considering each array has no duplicate numbers
		for(int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array2.length; j++) {
				if((array1[i] == array2[j]) && (array1[i]!= -1) && (array2[i]!=-1)) {
					System.out.println(array1[i]);
					// to avoid checking the same number again assigning with value -1
					array1[i] = -1;
					array2[j] = -1;
				}
			}
		}
	}

}
