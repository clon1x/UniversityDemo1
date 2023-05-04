package com.lvl.university.clients;

import com.lvl.university.model.Course;
import com.lvl.university.model.Student;

public class UniversityApp {

	public static void main(String[] args) {
		
		Student john = new Student("John");
		Student mary = new Student("Mary");
		
		System.out.println(john.getName());
		System.out.println(mary.getName());
		
		Course course = new Course("Object Oriented Programming", "1JAIL389");
		john.addCourse(course, 'B');
		
		System.out.println(john.getName() + " GPA: " + john.getGPA());
		
		System.out.println(mary);
		
		Student.setMinimumGPA(4.5);
		System.out.println("Minimum GPA: " + Student.getMinimumGPA());

	}

}
