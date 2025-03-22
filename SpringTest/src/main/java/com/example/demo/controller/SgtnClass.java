package com.example.demo.controller;

//Lazy initialization
 class SgtnClass {

	private SgtnClass() {
	}

	private static SgtnClass single_instance;

	public static synchronized SgtnClass getInstance() {
		if (single_instance == null) {
			single_instance = new SgtnClass();
		}
		return single_instance;
	}
}

//Eager Approch
 class SgtnClass2 {

	private SgtnClass2() {
	}

	private static class SingleHelper {
		private static final SgtnClass2 single_instance1 = new SgtnClass2();
	}

	public static SgtnClass2 getInstance() {
		return SingleHelper.single_instance1;
	}

}

//public static void main(String args[])
//{
//    SgtnClass x = SgtnClass.getInstance();
//}
