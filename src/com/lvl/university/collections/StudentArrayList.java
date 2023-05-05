package com.lvl.university.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lvl.university.model.Student;

public class StudentArrayList implements StudentList {

	List<Student> students = new ArrayList<>(); 
	
	@Override
	public void add(Student student) {
		students.add(student);
	}

	@Override
	public void delete(Student student) {
		students.remove(student);
	}

	@Override
	public Iterator<Student> iterator() {
		return students.iterator();
	}

	@Override
	public int size() {
		return students.size();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentList [");
		students.forEach(student -> builder.append(student + ", "));                            
		builder.replace(builder.length() - 2, builder.length(), "");
		builder.append("]");
		return builder.toString();
	}
	
}
