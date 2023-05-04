package com.lvl.university.collections;

import java.util.Iterator;

import com.lvl.university.model.Student;

public interface StudentList {
	
	public void add(Student student);
	public void delete(Student student);
	
	public Iterator<Student> iterator();

}
