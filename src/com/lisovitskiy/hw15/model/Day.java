package com.lisovitskiy.hw15.model;

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
}
