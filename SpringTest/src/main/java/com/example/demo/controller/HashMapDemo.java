package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] arg) {

		putMap("String1", 2);
		putMap("String2", 4);
		putMap("String3", 3);
		putMap("String1", 0);
		System.out.println(getMap("String1"));
		System.out.println(getMap("String2"));
		System.out.println(getMap("String3"));

	}

	static Set<List<Object>> objList = new HashSet<>();

	public static void putMap(Object o1, Object o2) {
		List<Object> arrList = new ArrayList<>();
		arrList.add(o1);
		arrList.add(o2);
		int h1 = arrList.hashCode();
//		arrList.add(h1);
		boolean flag = false;
		for (List<Object> obj : objList) {
			if (obj.hashCode() == h1) {
				List<Object> linkList = new LinkedList<>();
				linkList.add(obj);
				linkList.add(arrList);
				linkList.remove(obj);
				objList.add(linkList);
				flag = true;
			}
		}
		if (!flag)
			for (List<Object> obj : objList) {
				if (obj.get(0).equals(arrList.get(0))) {
					objList.remove(obj);
					objList.add(arrList);
					flag = true;
				}
			}
		if (!flag)
			objList.add(arrList);
	}

	public static Object getMap(Object o1) {
		for (List<Object> obj : objList) {
			if (obj.get(0).equals(o1))
				return obj.get(1);
		}
		return null;
	}

	public static boolean containsMap(Object o1) {
		for (List<Object> obj : objList) {
			if (obj.get(0).equals(o1))
				return true;
		}
		return false;
	}

	public static boolean getKeys(Object o1) {
		for (List<Object> obj : objList) {
			if (obj.get(0).equals(o1))
				return true;
		}
		return false;
	}
}
