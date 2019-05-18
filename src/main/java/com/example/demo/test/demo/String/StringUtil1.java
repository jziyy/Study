package com.example.demo.test.demo.String;

import java.util.ArrayList;
import java.util.List;

public class StringUtil1 {
	public static void main(String[] args) {
		List<String> listadditive = new ArrayList<String>();
		listadditive.add("");
		listadditive.add("a");
		listadditive.add("s");
		listadditive.add("a");
		listadditive.add("");
		listadditive.add("");

		listadditive.add("a");


		
		
		 for (int i = 0; i < listadditive.size(); ) {
				if (listadditive.get(i).equals("")) {
					listadditive.remove(i);
					continue;
				}
				i++;
			}
		 System.out.println(listadditive);
	}
}
