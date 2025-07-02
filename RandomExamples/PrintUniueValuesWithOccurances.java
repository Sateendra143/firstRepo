package Automation.Demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintUniueValuesWithOccurances {

	public static void main(String[] args) {

		List<String> list = List.of("Apple", "Banana", "Apple", "Cherry", "Banana", "Banana");
		//Map<String, Long> occurrences = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		//occurrences.forEach((key, value) -> System.out.println(key + ": " + value));
		list.stream().distinct().forEach(e-> System.out.println(e));
		//With Streams
		System.out.println("*******************************************************");
		list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).forEach((key, value) -> System.out.println(key + ": " + value));
		
		//Without Streams
		System.out.println("*******************************************************");
		Map<String, Integer> occurrences = new HashMap<>();
		for (String element : list) {
	            occurrences.put(element, occurrences.getOrDefault(element, 0) + 1);
	      }
		for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
	         System.out.println(entry.getKey() + ": " + entry.getValue());}
		
		//Without Streams
		System.out.println("*******************************************************");
		   Map<String, Integer> occurrence = new HashMap<>();
	       String mostRepeated = null;
	       int maxCount = 0;
	        for (String element : list) {
	            int count = occurrence.getOrDefault(element, 0) + 1;
	            occurrence.put(element, count);
	            if (count > maxCount) {
	                maxCount = count;
	                mostRepeated = element;
	            }
	        }
	        System.out.println("Most repeated value: " + mostRepeated + " (" + maxCount + " times)");
	        
	        
	      //With Streams
			System.out.println("*******************************************************");
//			Map<String, Long> occur = list.stream()
//			        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//
//			String mostRepeat = occur.entrySet().stream()
//			        .max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
//			        .get().getKey();
//
//			System.out.println("Most repeated value: " + mostRepeated + " (" + occur.get(mostRepeat) + " times)");
			
			list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()))
			.entrySet().stream().max((e,count) ->e.getValue().compareTo(count.getValue())).stream().forEach(e->System.out.println(e));
			//.forEach((key, value) -> System.out.println(key + ": " + value));
			
	}

}
