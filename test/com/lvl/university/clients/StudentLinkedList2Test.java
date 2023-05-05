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
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.lvl.university.collections.StudentArrayList;
import com.lvl.university.collections.StudentLinkedList;
import com.lvl.university.collections.StudentLinkedList2;
import com.lvl.university.collections.StudentList;
import com.lvl.university.model.Student;

class StudentLinkedList2Test {

	Student john = new Student("John");
	Student mary = new Student("Mary");

	private static Stream<Arguments> generateImplementations() {
		return Stream.of(
				Arguments.of(new StudentLinkedList()), 
				Arguments.of(new StudentLinkedList2()),
				Arguments.of(new StudentArrayList()));
	}

	@ParameterizedTest
	@MethodSource("generateImplementations")
	void should_ContainStudent_When_SingleStudentAddedToList(StudentList studentList) {

		// given
		studentList.add(john);
		Iterator<Student> iterator = studentList.iterator();
		int expectedSize = 1;

		// when
		int actualSize = studentList.size();
		Student student = iterator.next();

		// then
		assertAll("Check list content", 
				() -> assertEquals(expectedSize, actualSize, "Unexpected list size"), 
				() -> assertSame("Student is not John!", john, student),
				() -> assertFalse(iterator.hasNext(), "Should not have next"));

	}

	@ParameterizedTest
	@MethodSource("generateImplementations")
	void should_ContainAll_When_SeveralStudentsAddedToList(StudentList studentList) {

		// given
		studentList.add(john);
		studentList.add(mary);
		Iterator<Student> iterator = studentList.iterator();
		int expectedSize = 2;
		Set<Student> studentSet = new HashSet<>();

		// when
		int actualSize = studentList.size();
		iterator.forEachRemaining(student -> studentSet.add(student));
		
		// then
		assertAll("Check list content", 
				() -> assertEquals(expectedSize, actualSize, "Unexpected list size"), 
				() -> assertTrue(studentSet.contains(john), "John should be in list"),
				() -> assertTrue(studentSet.contains(mary), "Mary should be in list"));

	}
	@ParameterizedTest
	@MethodSource("generateImplementations")
	void should_Delete_When_DeleteFirstStudent(StudentList studentList) {

		// given
		studentList.add(john);
		studentList.add(mary);
		int expectedSize = 1;

		// when
		studentList.delete(john);
		Iterator<Student> iterator = studentList.iterator();
		int actualSize = studentList.size();

		// then
		assertAll("Verify List Content", 
				() -> assertEquals(expectedSize, actualSize, "Unexpected list size"),
				() -> assertSame("Student is not Mary!", mary, iterator.next()), 
				() -> assertFalse(iterator.hasNext(), "Shoul not have next"));

	}

	@ParameterizedTest
	@MethodSource("generateImplementations")
	void should_Delete_When_DeleteLastStudent(StudentList studentList) {

		// given
		studentList.add(john);
		studentList.add(mary);
		int expectedSize = 1;

		// when
		studentList.delete(mary);
		Iterator<Student> iterator = studentList.iterator();
		int actualSize = studentList.size();

		// then
		assertAll("Verify List Content", 
				() -> assertEquals(expectedSize, actualSize, "Size should be expected"),
				() -> assertSame("Student should be John", john, iterator.next()), 
				() -> assertFalse(iterator.hasNext(), "Should not have next"));

	}

	@ParameterizedTest
	@MethodSource("generateImplementations")
	void should_ReturnExpectedString_When_ToStringGetsCalled(StudentList studentList) {

		// given
		studentList.add(john);
		studentList.add(mary);
		String stringForJohn = john.toString();
		String stringForMary = mary.toString();
		String expectedBeginning = "StudentList [Student [";

		// when
		String actualString = studentList.toString();

		// then
		assertAll("Verify substrings", 
				() -> assertTrue(actualString.contains(stringForJohn), "String for John should be present"),
				() -> assertTrue(actualString.contains(stringForMary), "String for Mary should be present"),
				() -> assertEquals(expectedBeginning, actualString.substring(0, expectedBeginning.length()), "Should start with expected string"));
	}

	@ParameterizedTest
	@MethodSource("generateImplementations")
	void should_ReturnIterator_When_IteratorCalled(StudentList studentList) {

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
		assertAll( "Check iterator elements",
				() -> assertNotNull(iterator), 
				() -> assertEquals(2, studentSet.size()),
				() -> assertTrue(studentSet.contains(john)), 
				() -> assertTrue(studentSet.contains(mary)));

	}

}
