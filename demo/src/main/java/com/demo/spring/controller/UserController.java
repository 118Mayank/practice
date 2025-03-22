package com.demo.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/healthCheck")
	public String checkHealth() {
		return "Spring_Demo project is in running stage...!!";
	}

//Code to get list of distinct characters from array 
	@GetMapping("/run1")
	public Set<String> run1() {
//		List<String> words = Arrays.asList("apple", "banana", "cherry");
		Stream<String> words = Stream.of("apple", "banana", "cherry");
		Set<String> finalSet = new LinkedHashSet<>();
		words.forEach(word -> Arrays.stream(word.split("")).forEach(w -> finalSet.add(w)));
		return finalSet;
	}

// get single occurrence characters
	@GetMapping("/run2/{x}")
	public List<Character> run2(@PathVariable String x) {

		List<Character> resultList = new ArrayList<>();
		Map<Character, Integer> charMap = new HashMap<>();

		for (char s : x.toCharArray())
			charMap.put(s, charMap.containsKey(s) ? charMap.get(s) + 1 : 1);

		for (Map.Entry<Character, Integer> charMapp : charMap.entrySet())
			if (charMapp.getValue() == 1)
				resultList.add(charMapp.getKey());

		return resultList;

	}

//Code to lowercase the empname if sal is greate then 10K	
	@GetMapping("/run3")
	public List<Employee> getList(List<Employee> empList) {
		empList.stream().filter(emp -> emp.getEmpSalary() > 10000)
				.forEach(emp -> emp.setEmpName(emp.getEmpName().toLowerCase()));
		return empList;
	}

//code to return value from map if exists	
	@GetMapping("/run4")
	public List<Employee> getList() {
		Stream<String> st = Stream.of("st1", "st2", "st3");
		Map<String, String> mapst = new HashMap<>();
		// mapst.put("key1", "available");
		System.out.println(mapst.getOrDefault("key1", null));
		return null;
	}

//	@GetMapping("/run5")
//	public Map<String, Double> run2() {
//		Map<String, Double> resultList=new HashMap();
//
//		orders.stream().forEach(order->{
//			if(resultList.contains(orders.getCustomarCity())){
//				if(orders.getOrderAmout()<resultList.get(orders.getCustomarCity())
//					resultList.put(orders.getCustomarCity(),orders.getOrderAmout());
//			}
//			else
//				resultList.put(orders.getCustomarCity(),orders.getOrderAmout());
//
//		});
//		return resultList;
//	}

//code to remove a given value from array list having string values.
	@GetMapping("/run6/{x}")
	public List<Integer> getList1(@PathVariable int x) {

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
//		 intList.removeIf(item -> item.equals(x));
		return intList.contains(x) ? intList.stream().filter(i -> i != x).collect(Collectors.toList()) : intList;
	}

//Code to return the maximum value from an integer array passed as an input parameter.	
	@GetMapping("/run7")
	public Integer run7() {
		int z = 0;
		return Stream.of(1, 2, 3, 4, 45, 6, 7, 8).filter(i -> i > z).reduce(z, Integer::max);
	}

//Code to check whether the strings passed as input parameters are made up of the same set of characters.	
	@GetMapping("/run8/{str}")
	public boolean run8(@PathVariable String str) {
		return Arrays.asList(str.split("")).stream().allMatch(s -> Arrays.asList("a", "s").contains(s));
//		return Stream.of(str.toCharArray()).allMatch(Arrays.asList('a', 's')::contains);
	}

//Code to remove dublicate
	@GetMapping("/run9")
	public List<String> run9() {
		List<String> st = Arrays.asList("gergger", "gerger", "ferge", "sss", "sss");
		List<String> returnList = new ArrayList<>();
		st.stream().filter(s -> !returnList.contains(s)).forEach(returnList::add);
		return returnList;
	}

//Code to return the second largest element in an integer array passed as an input parameter.
	@GetMapping("/run10")
	public Integer run10() {
		List<Integer> st = Arrays.asList(44, 45, 67, 8, 995, 345345, 555555);
		int z = 0;
		int x = 0;
		int secondLargest = st.stream()
				.filter(s -> s > x && s < st.stream().filter(s1 -> s1 > z).reduce(z, Integer::max))
				.reduce(x, Integer::max);
		return secondLargest;
	}

//Code to reverse an integer array passed as an input parameter.	
	@GetMapping("/run11")
	public List<Integer> run11() {
		List<Integer> st = Arrays.asList(44, 45, 67, 8, 995, 345345, 555555);
		List<Integer> fianlList = new LinkedList<>();
		for (int s = st.size() - 1; s >= 0; s--)
			fianlList.add(st.get(s));
		return fianlList;
	}

	// Code to return the odd numbers.
	@GetMapping("/run12")
	public List<Integer> run12() {
		List<Integer> st = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		return st.stream().filter(s -> s % 2 != 0).collect(Collectors.toList());

	}

//Emplaye with highest salary
//	@GetMapping("/run13")
//	public List<Integer> run13() {
//		return st.stream().sorted(Comperator.compareDouble(s->s.salary).reverse()).findFirst().orElse(null);
//	}

//code to reverse String	
	@GetMapping("/run13")
	public Object run13() {
		String str = "My name is Mayank";
		String finalString = "";
		List<String> charList = Arrays.asList(str.split(""));
		for (int i = charList.size() - 1; i >= 0; i--) {
			finalString += charList.get(i).toString();
		}
		return finalString;

//		return str.chars()
//                .mapToObj(c -> (char) c)          // Convert int to Character
//                .collect(Collectors.toList())    // Collect as a List
//                .stream()
//                .sorted((a, b) -> -1)            // Sort in reverse order
//                .map(String::valueOf)            // Convert Character to String
//                .collect(Collectors.joining());
	}

//code to change lower to uppercase using functional interface
	@GetMapping("/run14")
	public Object run14() {
		List<Character> charList = Arrays.asList('a', 'b', 'c', 'd', 'e');
		Function<Character, Character> toUcase = a -> Character.toUpperCase(a);
		List<Character> uCharList = charList.stream().map(toUcase).collect(Collectors.toList());
		return uCharList;
	}

//Find the Second Largest Element in an Array
	@GetMapping("/run15")
	public Object run15() {
		int[] intArray = { 1, 2, 5, 6, 3, 2 };
		List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		int z = 0;
		return intList.stream().filter(x -> x > z).reduce(z, Integer::max);
	}

//Find the Longest String in an Array of Strings	
	@GetMapping("/run16")
	public Object run16() {
		String[] intArray = { "apple", "banana", "orange", "kiwi", "strawberry" };
		List<String> intList = Arrays.stream(intArray).collect(Collectors.toList());
		String st = null;
		int z = 0;
		for (String s : intList) {
			z = s.length() > z ? s.length() : z;
			st = s + " - " + s.length();
		}
		return st;
	}

//Find Two Numbers in an Array That Sum to a Target
	@GetMapping("/run17")
	public Object run17() {
		int[] intArray = { 2, 7, 11, 15, 9 };
		List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < intList.size(); i++) {
			for (int j = i; j < intList.size(); j++) {
				int z = intList.get(i) + intList.get(j);
				for (Integer a : intList) {
					if (z == a) {
						result.add(Arrays.asList(intList.get(i), intList.get(j)));
					}
				}
			}

		}
		return result;
	}

//Sum Digits of a Positive Integer Until a Single Digit is Obtained
	@GetMapping("/run18")
	public Object run18() {
		int intArray = 567;
		List<String> intList = Arrays.stream((intArray + "").split("")).collect(Collectors.toList());
//		int x = 0;
//		for (int i = 0; i < intList.size(); i++) 
//			x = Integer.parseInt(intList.get(i)) + x;
		return intList.stream().mapToInt(Integer::parseInt).sum();
	}

//Get n gretest number
	@GetMapping("/run19")
	public Object run19() {
		int n = 5;
//		List<Integer> intList = Arrays.asList(2, 5, 3, 65, 33, 31, 56, 768, 23);
//		intList.sort(null);
//		return intList.get(n - 1);
		return Arrays.asList(2, 5, 3, 65, 33, 31, 56, 768, 23).stream().sorted((a, b) -> b - a).skip(n - 1).limit(1);

	}

//Set diagonal 0 in matrix
	@GetMapping("/run20")
	public Object run20() {
		List<List<Integer>> finalResultArray = new ArrayList<>();
		List<Integer> resultArray = new ArrayList<>();
		List<Integer> operationalArray = new ArrayList<>();
		operationalArray.addAll(Arrays.asList(2, 5, 3, 6));
		operationalArray.addAll(Arrays.asList(2, 5, 3, 6));
		operationalArray.addAll(Arrays.asList(2, 5, 3, 6));
		operationalArray.addAll(Arrays.asList(2, 5, 3, 6));
		int sz = 4;

		for (int j = 0; j < operationalArray.size(); j++) {
			if (j == 0 || j % (sz - 1) == 0)
				resultArray.add(j, 0);
			else
				resultArray.add(j, operationalArray.get(j));
		}
		for (int x = 0; x < operationalArray.size() / sz; x++)
			System.out.println(resultArray.subList(x, x + sz));

//		System.out.println(finalResultArray);

		return null;
	}

	@GetMapping("/run21")
	public void stringSorting() {
		ArrayList<String> cars = new ArrayList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");
		cars.stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());

		ArrayList<String> carss = new ArrayList<String>();
		carss.add("Volvo");
		carss.add("BMW");
		carss.add("Ford");
		carss.add("Mazda");
		carss.stream().sorted().collect(Collectors.toList());
	}

	@GetMapping("/run22")
	public static int compareByAge(@RequestParam String a, @RequestParam String b) {
		return a.compareTo(b);
	}

	@GetMapping("/run22īl̥")
	public List<String> SyncCollection() {
		List<String> cars = new ArrayList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");
		//1 way
		List<String> syncCollection = Collections.synchronizedList(cars);
		//2 way
		synchronized(cars) {
		}
		
		return syncCollection;
	}
}