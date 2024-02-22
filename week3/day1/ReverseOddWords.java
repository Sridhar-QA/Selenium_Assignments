package week3.day1;

public class ReverseOddWords {

	public static String reverseWord(String word) {
		String reversedWord = "";
		for(int i = word.length() -1; i >=0 ; i--) {
			reversedWord = reversedWord + Character.toString(word.charAt(i));
		}
		return reversedWord;
	}
	public static void main(String[] args) {
		String test = "I am a software tester";
		
		// split the test string to array of words
		String[] words = test.split(" ");
		
		// reverse the words that are present in odd position
		for(int i = 0; i< words.length; i++) {
			String s = "";
			if((i % 2 != 0)) {
				words[i] = reverseWord(words[i]);
			}
		}
		
		System.out.println("Original String: "+ test);
		System.out.println("Reversed String: "+ String.join(" ",words));
	}

}
