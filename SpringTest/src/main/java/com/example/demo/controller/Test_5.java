package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test_5 {

	public static void main(String arg[]) {

		 String l[] = {"pp","apple", "appl", "app" };

		System.out.println(longestCommonPrefix(l));
//		String smallectEle = l.stream().sorted().skip(l.size() - 1).limit(1).collect(Collectors.toList()).get(0);
//
//		System.out.println(smallectEle);
//		
//		for(String st:l) {
//			for(int i)
//		}
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Sort the array lexicographically
        Arrays.sort(strs);

        // Take the first and last string after sorting
        String first = strs[0];
        String last = strs[strs.length - 1];

        // Compare characters one by one
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return first.substring(0, i);
}
}
