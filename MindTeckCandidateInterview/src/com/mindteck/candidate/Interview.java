package com.mindteck.candidate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bin
 * 
 */

public class Interview {

	private List<String> inputNames;
	private int i;
	

	public Interview(int i) {
		super();
		this.i = i;
	}

	public Interview() {
		super();
		this.inputNames = new ArrayList<>();
		
	}

	public boolean addName(String name) {
		validateName(name);    
		return this.inputNames.add(name);		
		
	}
	
	
	
	/**
	 * @checks if the input String contains only valid chars
	 * @return boolean
	 */
	static void validateName(String name){
		if(!name.matches("[a-zA-Z]*"))
			throw new IllegalArgumentException("not valid");		
		
	}

	/**
	 * This method changes each String to mixed case, where the first letter is
	 * capitalized, and the rest is all lower case (e.g., PETER to Peter)
	 * 
	 * @return String returns the mixed case string
	 */
	static String toMixedCase(String name) {
		StringBuilder sb = new StringBuilder(name.toLowerCase());
		sb.replace(0, 1, sb.substring(0, 1).toUpperCase());
		return sb.toString();

	}

	/**
	 * This method Calculate each person’s birthday as April 6th, with the year
	 * of the birthday equal to 1990 minus the length of the name). For example,
	 * Peter’s birthday would be April 6th, 1985.
	 * 
	 * @return Date returns the birth Date of the person
	 */
	static Date calculateBirthday(String name) {
		int nameLength = name.length();
		Calendar cal = new GregorianCalendar();
		//set year, month and date for the cal object
		cal.set(1990 - nameLength, Calendar.APRIL, 6);
		return cal.getTime();

	}

	/**
	 * puts the name and Birth date of each person as key and Value respectively
	 * into a Map
	 * 
	 * @return Map returns name and birth date pair as Map
	 */
	public Map<String, Date> addToMap(List<String> names) {
		Map<String, Date> nameBirthdayMap = new HashMap<String, Date>();
		for (String name : names) {
			nameBirthdayMap.put(toMixedCase(name), calculateBirthday(name));
		}
		return nameBirthdayMap;
	}

	/**
	 * Iterates over the Map and prints out the person’s name, year they were
	 * born, and their age
	 */
	public void displayNameAndAge() {
		Calendar cal = new GregorianCalendar();
		Calendar now = new GregorianCalendar();

		for (Map.Entry<String, Date> entry : addToMap(this.inputNames)
				.entrySet()) {
			cal.setTime(entry.getValue());
			int age = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
			System.out.println(entry.getKey() + " was born in "
							+ cal.get(Calendar.YEAR) + " and is " + age
							+ " years old.");
		}
	}

	public List<String> getInputNames() {
		return inputNames;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interview interview = new Interview();
		interview.addName("MARY");
		interview.addName("JOE");
		interview.addName("SIENNA");
		interview.addName("PETER");		
		Interview a = new Interview(1);
		Interview c=a;
		Interview b = new Interview(1);
        System.out.println(a.equals(b));
		interview.displayNameAndAge();
		
		System.out.println("Test 1");
		
	}

}
