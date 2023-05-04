package com.lvl.university.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.lvl.university.model.Student;

public class StudentLinkedList implements StudentList {

	List<Student> students = new LinkedList<>();
	
	@Override
	public void add(Student student) {
		students.add(student);
	}

	@Override
	public void delete(Student student) {
		students.remove(student);
	}

	@Override
	public String toString() {
		return "StudentLinkedList [students=" + students + "]";
	}

	@Override
	public Iterator<Student> iterator() {
		return students.iterator();
	}

	@Override
	public int size() {
		return students.size();
	}

}
