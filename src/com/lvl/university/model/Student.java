package com.lvl.university.model;

public class Student extends Person {

	private static double minimumGPA = 5;

	/**
	 * Grade Point Average
	 */
	private double gpa;

	public Student(String name) {
		super(name);
	}
	
	public Student(String name, String address) {
		super(name);
		setAddress(address);
	}
	
	public static double getMinimumGPA() {
		return minimumGPA;
	}

	public static void setMinimumGPA(double minimumGPA) {
		Student.minimumGPA = minimumGPA;
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
		return "Student [name=" + getName() + ", address=" + getAddress() + ", gpa=" + gpa + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Person other = (Person) obj;
			return (this.getName() == other.getName())
					&& (this.getAddress() == other.getAddress());
		}
		return false;
	}
	
}
