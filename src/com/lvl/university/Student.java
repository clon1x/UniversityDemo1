package com.lvl.university;

public class Student {

	private static double minimumGPA = 5;

	private String name;
	private String address;
	/**
	 * Grade Point Average
	 */
	private double gpa;

	public Student() {}
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public static double getMinimumGPA() {
		return minimumGPA;
	}

	public static void setMinimumGPA(double minimumGPA) {
		Student.minimumGPA = minimumGPA;
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
		if (this.gpa < Student.minimumGPA) {
			// put student on academic probation
		}
	}

	public double getGPA() {
		return gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", gpa=" + gpa + "]";
	}
	
}
