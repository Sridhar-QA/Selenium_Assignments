package week3.day1;

public class ConvertToUppercase {

	public static void main(String[] args) {
		String test = "changeme";
		
		// convert string to character array
		char[] characters = test.toCharArray();
		String modifiedWord = "";
		
		// iterate the update the characters to uppercase for odd positions
		for(int i = 0; i<characters.length; i++) {
			if(i%2==1) {
				characters[i]=Character.toUpperCase(characters[i]);
			}
		}
		
		// convert charcterArray to string
		for(int i=0; i<characters.length; i++) {
			modifiedWord+=Character.toString(characters[i]);
		}
		
		// print the output
		System.out.println("Original String: "+test);
		System.out.println("Modified String: "+ modifiedWord);
	}

}
