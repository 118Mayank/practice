package com.demo.spring.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class wayfiar_1 {

	@PostMapping("/addNo")
	public StringBuilder add(@RequestParam String s1, @RequestParam String s2) {
		s1.replaceAll(",", "");
		s2.replaceAll(",", "");
		String addData = "";
		int rev = 0;
		int comma=0;
		int lenth = s1.length() > s2.length() ? s1.length() : s1.length();
		for (int i = 1; i <= lenth; i++) {
			int x1 = Integer.parseInt(s1.charAt(s1.length() - i) + "");
			int x2 = s2.length()-i<0?0: Integer.parseInt(s2.charAt(s2.length() - i) + "");
			int temp = x1 + x2 + rev;
			rev = temp / 10;
			addData = (temp % 10) + addData;
		}
		addData= rev>0?rev+addData:addData;	
		StringBuilder result = new StringBuilder();
//		int noComma=addData.length()/3;
//		for(int j=addData.length();j<=addData.length();j-3) {
//			addData.charAt(j);			
//		}
		
		for (int i = 0; i < addData.length(); i++) {
			result.append(addData.charAt(i));
            if ((i + 1) % 3 == 0 && i != s1.length() - 1) {
            	result.append(",");
            }
        }
		
		return result;

	}
}
