package com.demo.spring.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class tempTwo {

	public static void main(String arg[]) {
		String str = "rroohh";
		List<String> strList = Arrays.asList(str.split(""));

		Map<String, Integer> m = new LinkedHashMap<>();
		for (String s : strList) {
			m.put(s, m.containsKey(s) ? m.get(s) + 1 : 1);
		}
		for (Entry<String, Integer> map : m.entrySet()) {
			if (map.getValue() == 1) {

					if(Objects.nonNull(map.getKey()){
				fetch(map.getKey());
		
					}
				break;
			}

		}
		
	}

	private static void fetch(String key) {
		// TODO Auto-generated method stub

	}

}
