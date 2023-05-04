package com.lvl.clients;

import com.lvl.university.Course;
import com.lvl.university.Student;

public class UniversityApp {

	public static void main(String[] args) {
		
		Student john = new Student("John");
		Student mary = new Student("Mary");
		
		System.out.println(john.getName());
		System.out.println(mary.getName());
		
		Course course = new Course();
		john.addCourse(course, 'B');
		
		System.out.println(john.getName() + " GPA: " + john.getGPA());

	}

}
