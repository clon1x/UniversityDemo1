package com.lvl.university.clients;

import com.lvl.university.model.Course;
import com.lvl.university.model.Section;
import com.lvl.university.model.Student;

public class UniversityApp {

	public static void main(String[] args) {
		
		Student john = new Student("John");
		Student mary = new Student("Mary");
		
		System.out.println(john.getName());
		System.out.println(mary.getName());
		
		Course course = new Course("Object Oriented Programming", "1JAIL389");
		Section section = course.createSection("Fall 2023", "Lecture Hall 12", "T H 1-2:15");
		
		john.addCourse(course, 'B');
		
		System.out.println(john.getName() + " GPA: " + john.getGPA());
		
		System.out.println(mary);
		
		Student.setMinimumGPA(4.5);
		System.out.println("Minimum GPA: " + Student.getMinimumGPA());

	}

}
