package week3.day1;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class RemoveDuplicateWords {

	public static void main(String[] args) {
		String text = "We learn Java basics as part of java sessions in java week1";
		
		// convert the string to array of words
		String[] words = text.split(" ");
		
		// declare map
		Map<String, Integer> wordsCount = new HashMap<String, Integer>();
		
		// enter the count of each words in the map
		for(int i=0; i < words.length; i++) {
			if(wordsCount.containsKey(words[i])) {
				wordsCount.put(words[i], wordsCount.get(words[i])+1);
			}else {
				wordsCount.put(words[i], 1);
			}
		}
		
		// update the repeated words with empty space
		for(int i = 0; i< words.length; i++) {
			if(wordsCount.get(words[i]) > 1) {
				words[i] = " ";
			}
		}
		
		// print the output by joining with " "
		System.out.println("Original String: "+text);
		System.out.println(String.join(" ", words));
		
	}

}
