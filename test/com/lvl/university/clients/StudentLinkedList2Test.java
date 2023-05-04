package com.lvl.university.clients;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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
	}

	@Nested
	class AddTests {

		@Test
		void should_ContainSingleStudent_When_AddedToList() {
			
			// given
			Iterator<Student> iterator = studentList.iterator();
			studentList.add(john);
			int expectedSize = 1;
			
			// when
			int actualSize = studentList.size();
			Student student = iterator.next();
			
			// then
			assertAll("Check list content",
					() -> assertEquals(expectedSize, actualSize),
					() -> assertSame(john, student),
					() -> assertFalse(iterator.hasNext()));
			
		}
		
	}
	
	@Nested
	class DeleteTests {

		@Test
		void testDeleteFirst() {
			
			// given 
			Iterator<Student> iterator = studentList.iterator();
			studentList.add(john);
			studentList.add(mary);
			int expectedSize = 1;
			
			// when
			studentList.delete(john);
			int actualSize = studentList.size();
			
			// then
			assertAll("Verify List Content",
					() -> assertEquals(expectedSize, actualSize), 
					() -> assertSame(mary,iterator.next()),
					() -> assertFalse(iterator.hasNext()));
			
		}

		@Test
		void testDeleteSecond() {
			
			// given 
			Iterator<Student> iterator = studentList.iterator();
			studentList.add(john);
			studentList.add(mary);
			int expectedSize = 1;
			
			// when
			studentList.delete(mary);
			int actualSize = studentList.size();
			
			// then
			assertAll("Verify List Content",
					() -> assertEquals(expectedSize, actualSize), 
					() -> assertSame(mary,iterator.next()),
					() -> assertFalse(iterator.hasNext()));
			
		}
		
	}

	@Test
	void testToString() {
		
		// given 
		studentList.add(john);
		studentList.add(mary);
		String stringForJohn = john.toString();
		String stringForMary = mary.toString();
		
		// when
		String actualString = studentList.toString();
		
		// then
		assertAll("Comprobar substrings",
				() -> assertTrue(actualString.contains(stringForJohn)),
				() -> assertTrue(actualString.contains(stringForMary)));
		System.out.println(actualString);
	}

	@Test
	void testIterator() {
		
		// given
		studentList.add(john);
		studentList.add(mary);
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
