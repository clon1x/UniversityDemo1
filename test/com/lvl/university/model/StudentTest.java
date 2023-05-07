package com.lvl.university.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StudentTest {

	@Nested
	class EqualsTests {
		
		@Test
		void should_BeEqual_When_SameNameAndAddress() {
			
			// given 
			String name = "John";
			String address = "18th Union Street";
			Student studentA = new Student(name, address);
			Student studentB = new Student(name, address);
			
			// when
			boolean condition = studentA.equals(studentB);
			
			// then
			assertTrue(condition, "Students A and B should be equal");
			
		}
		
		
		@Test
		void should_NotBeEqual_When_DifferentName() {
			
			// given 
			String address = "18th Union Street";
			Student studentA = new Student("John", address);
			Student studentB = new Student("Johnny", address);
			
			// when
			boolean condition = studentA.equals(studentB);
			
			// then
			assertFalse(condition, "Students A and B should not be equal");
			
		}
	}

}
