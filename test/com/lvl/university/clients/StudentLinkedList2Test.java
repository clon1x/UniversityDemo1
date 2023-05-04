package com.lvl.university.clients;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lvl.university.collections.StudentLinkedList2;
import com.lvl.university.collections.StudentList;
import com.lvl.university.model.Student;

class StudentLinkedList2Test {
	
	StudentList studentList;
	Student john = new Student("John");
	Student mary = new Student("Mary");

	@BeforeEach
	void setUp() throws Exception {
		studentList = new StudentLinkedList2();
		studentList.add(john);
		studentList.add(mary);
	}

	@Test
	void testAdd() {
		
		// given
		int expected = 2;
		
		// when
		int actual = studentList.size();
		
		// then
		assertEquals(expected, actual);
		
	}

	@Test
	void testDeleteFirst() {
		
		// given 
		int expected = 1;
		
		// when
		studentList.delete(john);
		int actual = studentList.size();
		
		// then
		assertEquals(expected, actual);
		
	}

	@Test
	void testDeleteSecond() {
		
		// given 
		int expected = 1;
		
		// when
		studentList.delete(mary);
		int actual = studentList.size();
		
		// then
		assertEquals(expected, actual);
		
	}

	@Test
	void testToString() {
		String actual = studentList.toString();
		System.out.println(actual);
	}

	@Test
	void testIterator() {
		
		// given
		Set<Student> studentSet = new HashSet<>();
		
		// when
		Iterator<Student> iterator = studentList.iterator();
		while (iterator.hasNext()) {
			studentSet.add(iterator.next());
		}
		
		// then
		assertAll(
				() -> assertNotNull(iterator),
				() -> assertEquals(2, studentSet.size()),
				() -> assertTrue(studentSet.contains(john)),
				() -> assertTrue(studentSet.contains(mary)));

	}

}
