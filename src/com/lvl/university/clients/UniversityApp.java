package com.lvl.university.clients;

import java.util.Iterator;

import com.lvl.university.collections.StudentArrayList;
import com.lvl.university.collections.StudentList;
import com.lvl.university.model.Course;
import com.lvl.university.model.Section;
import com.lvl.university.model.Student;

public class UniversityApp {

	public static void main(String[] args) {
		
		Student john = new Student("Holmes, Sherlock", "21, Baker Street, LONDON, England");
		Student mary = new Student("Bell, Marie-Jeanne", "64 Lafayette Rd., PARIS, France");
		
		System.out.println(john.getName());
		System.out.println(mary.getName());
		
		Course course = new Course("Object Oriented Programming", "1JAIL389");
		Section section = course.createSection("Fall 2023", "Lecture Hall 12", "T H 1-2:15");
		
		john.addCourse(course, 'B');
		
		System.out.println(john.getName() + " GPA: " + john.getGPA());
		
		Student.setMinimumGPA(4.5);
		System.out.println("Minimum GPA: " + Student.getMinimumGPA());

		
		StudentList students = new StudentArrayList();
		students.add(john);
		students.add(mary);

		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(String.format("%1$-25s\tAddress: %2$-50s\tGPA: %3$-2s" , student.getName(), student.getAddress(), student.getGPA()));
		}
		
	}

}
