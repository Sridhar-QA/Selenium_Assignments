package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseSort {

	public static void main(String[] args) {
		String[] companies = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		List<String> companyList = new ArrayList<String>(Arrays.asList(companies));
		Collections.sort(companyList);
		// approach 1: using inbuilt method reverse form collections
		// Collections.reverse(companyList); // using reverse function
		
		// approach 2
		for(int i = companyList.size()-1; i>=0; i--) {			
			System.out.println(companyList.get(i));
		}
	}

}
