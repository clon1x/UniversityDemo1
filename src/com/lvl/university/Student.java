package com.lvl.university;

public class Student {

	private String name;
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

	public void addCourse(Course newCourse) {
		//TODO code to store a ref to a new course in the student object
	}
	
	private void computeGPA() {
		// code to access the stored courses, compute and set the gpa
	}
	
	public double getGPA() {
		return gpa;
	}
	
	public void assignGrade(Course course, char newGrade) {
		// code to assign newGrade to a course
		computeGPA();
	}
	
}
