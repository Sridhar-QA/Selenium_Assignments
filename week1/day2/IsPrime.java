package week1.day2;

public class IsPrime {
	
	//approach 1
	public boolean isPrime(int number) {
		if(number <= 1) {
			return false;
		}
		for(int i = 2; i < number; i++ ) {
			if(number%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	//approach 2
	public boolean isPrimeOptimized(int number) {
		if(number <= 1) {
			return false;
		}
		for(int i = 2; i <= Math.sqrt(number); i++ ) {
			if(number%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	

	public static void main(String[] args) {
		int number = 1;
		IsPrime prime = new IsPrime();
		if(prime.isPrime(number)) {
			System.out.println(number + " is a prime number");
		}else {
			System.out.println(number + " is not a prime number");
		}
		
		System.out.println("<-----Optimized Approach---->");
		
		if(prime.isPrimeOptimized(number)) {
			System.out.println(number + " is a prime number");
		}else {
			System.out.println(number + " is not a prime number");
		}
	}

}
