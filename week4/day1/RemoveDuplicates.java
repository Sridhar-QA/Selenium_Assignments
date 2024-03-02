package week4.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String companyName = "google";
		char[] characters = companyName.toCharArray();
		Set<Character> uniqCharacters = new LinkedHashSet<Character>();
		String result = "";
		for(int i = 0; i < characters.length; i++) {
			if(!uniqCharacters.contains(characters[i])) {
				uniqCharacters.add(characters[i]);
			}
		}
		List<Character> setToList = new ArrayList<Character>(uniqCharacters);
		
		for(int i = 0; i < setToList.size(); i++) {
			result+=Character.toString(setToList.get(i));
		}
		
		System.out.println("original string : "+companyName);
		System.out.println("after removing duplicates: "+result);
	}

}
