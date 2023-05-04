package com.lvl.university;

public class Student {

	private String name;
	private String address;
	/**
	 * Grade Point Average
	 */
	private double gpa;

	public Student(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void addCourse(Course newCourse, char grade) {
		// use the grade and course to update GPA
	}

	public double getGPA() {
		return gpa;
	}
	
}
