package com.lvl.clients;

import com.lvl.university.Course;
import com.lvl.university.Student;

public class UniversityApp {

	public static void main(String[] args) {
		
		Student student1 = new Student();
		Student student2 = new Student();
		
		student1.setName("John");
		student2.setName("Mary");
		
		System.out.println(student1.getName());
		System.out.println(student2.getName());
		
		Course course = new Course();
		student1.addCourse(course);
		student1.assignGrade(course, 'B');
		
		System.out.println(student1.getName() + " GPA: " + student1.getGPA());

	}

}
