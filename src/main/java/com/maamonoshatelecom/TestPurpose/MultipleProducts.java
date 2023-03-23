package com.maamonoshatelecom.TestPurpose;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MultipleProducts {

	public static void main(String[] args) {
		Map<String, Integer> map = new TreeMap<>();
		
		map.put("ORD00005", 2);
		map.put("ORD00002", 1);
		map.put("ORD00003", 1);
		map.put("ORD00001", 1);
		
		System.err.println(map);
		map.put("ORD00001", map.get("ORD00001")+5);
		System.err.println(map.get("ORD00001"));
		if(!map.containsKey("ORD00001")) {
			System.out.println("Contains");
		}
		
		for(Map.Entry<String, Integer> m : map.entrySet()) {
			for(int i=0;i<m.getValue();i++) {
				System.out.println(m.getKey()+" "+ i + " Time");
			}
		}
		
		// Get the current date and time
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println("Current date and time: " + now);
//        
//        
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
//        
//        System.out.println("Line no 25 : "+now.format(formatter));
//        
//        
//        // Create a LocalDateTime object for a specific date and time
//        LocalDateTime dateTime = LocalDateTime.of(2022, 1, 22, 8, 30, 0);
//        System.out.println("Specific date and time: " + dateTime);
//        
//        // Manipulate a LocalDateTime object using methods such as plusDays, minusHours, etc.
//        LocalDateTime tomorrow = now.plusDays(1);
//        System.out.println("Tomorrow's date and time: " + tomorrow);
//        
//        // Format a LocalDateTime object as a string using DateTimeFormatter
//        String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println("Formatted date and time: " + formattedDateTime);
		
//		String dateString = "2022-01-20T13:45:30";
//
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
////		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
//		LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
//
//		System.out.println(dateTime);
//		System.out.println(LocalDateTime.now());
		
		
		
		
	}
}
