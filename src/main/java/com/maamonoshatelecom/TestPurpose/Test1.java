package com.maamonoshatelecom.TestPurpose;

import java.util.HashSet;
import java.util.Set;

enum Status{
	WAITING_FOR_CONFIRMATION,
	ORDER_CONFIRMED,
	DISPATCH,
	OUT_FOR_DELIVERY,
	RECEIVED
}

public class Test1 {
	public static void main(String[] args) {
		Set<Integer> testSet = new HashSet<Integer>();
		
		testSet.add(1);
		testSet.add(1);
		testSet.add(2);
		testSet.add(3);
		testSet.add(3);
		testSet.add(4);
		
//		System.out.println(testSet);
		
		Status status = Status.ORDER_CONFIRMED;
		
		System.out.println(status);
	}
}
