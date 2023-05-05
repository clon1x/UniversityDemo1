package com.lvl.university.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import com.lvl.university.model.Student;

public class StudentArrayList2 implements StudentList {

	private Student[] students;
	private int size;
	
	public StudentArrayList2() {
		this(10);
	}
	
	public StudentArrayList2(int size) {
		students = new Student[size];
		this.size = 0;
	}

	@Override
	public void add(Student student) {
		if (size == students.length) reallocate(size * 2);
		students[size++] = student;
	}

	private void reallocate(int newSize) {
		Arrays.copyOf(students, newSize);
	}

	@Override
	public void delete(Student student) {
		for (int i = 0; i < size; i++) {
			if (students[i].equals(student)) {
				students[i] = students[size - 1];
				students[--size] = null;
			}
		}
	}

	@Override
	public Iterator<Student> iterator() {
		return Stream.of(students).filter(student -> (student != null)).iterator();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentList [");
		for (int i = 0; i < size; i++ ) {
			builder.append(students[i] + ", ");
		}
		builder.replace(builder.length() - 2, builder.length(), "");
		builder.append("]");
		return builder.toString();
	}

}
