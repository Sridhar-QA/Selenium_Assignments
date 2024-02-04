package week1.day2;

public class Palindrome {

	public boolean isPalindrome(int number) {
		int num = number < 0? Math.abs(number) : number;
		int sum = 0;
		while(num != 0) {
			int remainder = num % 10;
			sum = sum * 10 + remainder;
			num = num/10;
		}
		if(number < 0) {
			sum = -1 * sum;
			if(sum == number) {
				return true;
			}
		}
		if(sum == number) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int number = -101;
		Palindrome pal = new Palindrome();
		if(pal.isPalindrome(number)) {
			System.out.println(number + " is a Palindrome");
		}else {
			System.out.println(number + " is not a Palindrome");
		}
	}

}
