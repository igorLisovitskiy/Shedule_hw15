package com.lisovitskiy.hw15.model;

import java.util.Arrays;
import java.util.Optional;

public enum Day {
	
	MONDAY("Mon"), 
	TUESDAY("Tue"), 
	WEDNESDAY("Wed"), 
	THURSDAY("Thu"), 
	FRIDAY("Fri"), 
	SATURDAY("Sat"), 
	SUNDAY("Sun");
	
	private String day;

	Day(String day) {
		this.day = day;
	}
	public String getDay(){
		return day;
	}
	public static Day dayToDay(String day) {
		Day dDay = null;
		Day[] days = Day.values();
		Optional<Day> present = Arrays.stream(days).filter(el -> day.equals(el.day)).findFirst();
		if(present.isPresent()) {
			dDay = present.get();
		}
		return dDay;
	}
}
