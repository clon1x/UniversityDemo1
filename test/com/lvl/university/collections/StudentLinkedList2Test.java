package com.lvl.university.collections;

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

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.lvl.university.collections.StudentArrayList;
import com.lvl.university.collections.StudentArrayList2;
import com.lvl.university.collections.StudentLinkedList;
import com.lvl.university.collections.StudentLinkedList2;
import com.lvl.university.collections.StudentList;
import com.lvl.university.model.Student;

class StudentLinkedList2Test {

	Student john = new Student("John");
	Student mary = new Student("Mary");

	static class ArgProvider implements ArgumentsProvider {

		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext arg0) throws Exception {
			return Stream.of(
					Arguments.of(new StudentLinkedList()), 
					Arguments.of(new StudentLinkedList2()),
					Arguments.of(new StudentArrayList()),
					Arguments.of(new StudentArrayList2(4)));
		}
		
	}
	
	@Nested
	class AddTests {

		@ParameterizedTest
		@ArgumentsSource(ArgProvider.class)
		void should_ContainStudent_When_SingleStudentAddedToList(StudentList studentList) {
		
			// given
			int expectedSize = 1;
		
			// when
			studentList.add(john);
			Iterator<Student> iterator = studentList.iterator();
			int actualSize = studentList.size();
			Student student = iterator.next();
		
			// then
			assertAll("Check list content", 
					() -> assertEquals(expectedSize, actualSize, "Unexpected list size"), 
					() -> assertSame("Student is not John!", john, student),
					() -> assertFalse(iterator.hasNext(), "Should not have next"));
		
		}

		@ParameterizedTest
		@ArgumentsSource(ArgProvider.class)
		void should_ContainAll_When_TwoStudentsAddedToList(StudentList studentList) {
		
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
		@ArgumentsSource(ArgProvider.class)
		void should_HaveCorrectSize_When_ManyStuddentsAddedToList(StudentList students) {
			
			// given
			students.add(new Student("Anthony"));
			students.add(new Student("Michael"));
			students.add(new Student("Joseph"));
			students.add(new Student("Christian"));
			students.add(new Student("Mary"));
			students.add(new Student("Xavier"));
			students.add(new Student("Lewis"));
			students.add(new Student("Glory"));
			students.add(new Student("Albert"));
			students.add(new Student("Charles"));
			students.add(new Student("Henry"));
			students.add(new Student("Anne"));

			int expectedSize = 12;
			
			// when
			int actualSize = students.size();

			// then
			assertEquals(expectedSize, actualSize, "Size should be as expected");
			
		}
		
	}
	
	@Nested
	class DeleteTests {

		@ParameterizedTest
		@ArgumentsSource(ArgProvider.class)
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
		@ArgumentsSource(ArgProvider.class)
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
		
	}
	
	@Nested
	class ToStringTests {

		@ParameterizedTest
		@ArgumentsSource(ArgProvider.class)
		void should_ReturnExpectedString_When_ToStringGetsCalled(StudentList studentList) {
		
			// given
			studentList.add(john);
			studentList.add(mary);
			String expectedBeginning = "StudentList [Student [";
		
			// when
			String actualString = studentList.toString();
		
			// then
			assertAll("Verify substrings", 
					() -> assertTrue(actualString.contains(john.toString()), "String for John should be present"),
					() -> assertTrue(actualString.contains(mary.toString()), "String for Mary should be present"),
					() -> assertEquals(expectedBeginning, actualString.substring(0, expectedBeginning.length()), "Should start with expected string"));
		}
		
	}
	
	@Nested
	class IteratorTests {

		@ParameterizedTest
		@ArgumentsSource(ArgProvider.class)
		void should_ReturnIterator_When_IteratorCalled(StudentList studentList) {
		
			// given
			studentList.add(john);
			studentList.add(mary);
			Set<Student> studentSet = new HashSet<>();
			int expectedSize = 2;
		
			// when
			Iterator<Student> iterator = studentList.iterator();
			while (iterator.hasNext()) {
				studentSet.add(iterator.next());
			}
			int actualSize = studentSet.size();
		
			// then
			assertAll( "Check iterator elements",
					() -> assertNotNull(iterator), 
					() -> assertEquals(expectedSize, actualSize, "Size should be right"),
					() -> assertTrue(studentSet.contains(john), "John should be in list"), 
					() -> assertTrue(studentSet.contains(mary), "Mary should be in list"),
					() -> assertFalse(studentSet.contains(null), "Set should not contain null"));
		
		}
		
	}

}
