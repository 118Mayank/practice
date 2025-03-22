package com.demo.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Mincode {

	@GetMapping("/dubnum")
	public List<Integer> dnymber() {
		List<Integer> inumbers = Arrays.asList(1, 2, 2, 1);

		Map<Integer, Integer> rep = new HashMap<>();
		for (Integer inumber : inumbers)
			rep.put(inumber, rep.containsKey(inumber) ? rep.get(inumber) + 1 : 1);

		List<Integer> i = new ArrayList<>();
		for (Map.Entry<Integer, Integer> d : rep.entrySet()) {
			if (d.getValue() > 1) {
				i.add(d.getKey());
			}

		}
		return i;

	}
}