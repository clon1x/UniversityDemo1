package com.lvl.university.model;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CourseTest {
	
	Course course;
    private static final String DAYS_AND_TIMES = "MWF 16-17";
    private static final String PLACE = "Room 25";
    private static final String SEMESTER = "Fall 2023";
    private Section section0;

	@BeforeEach
	void setUp() throws Exception {
		course = new Course("HowTo Fly", "FLY1");
        section0 = course.createSection(CourseTest.SEMESTER, CourseTest.PLACE, CourseTest.DAYS_AND_TIMES);
	}

	@Nested
	class CreateSectionTests {

		@Test
		void should_ReturnSection_When_CreateSection() {

		    // given
            String semester = "Spring 2023";
            String place = "Room 1";
            String daysAndTimes = "Mon.17:00";
		    
			// when
            Section section1 = course.createSection(semester, place, daysAndTimes);
			
			// then
			assertAll( "Section Values",
					() -> assertNotNull(section1, "Section should not be null"),
					() -> assertEquals(semester, section1.getSemester()),
					() -> assertEquals(place, section1.getPlace()),
					() -> assertEquals(daysAndTimes, section1.getDaysAndTimes()),
					() -> assertEquals(Section.DEFAULT_SECTION_CAPACITY, section1.getCapacity()),
					() -> assertEquals(0, section1.getNumOfStudentsEnrolled())
					);
		}
		
		@Test
		void should_ContainOneSection_When_CreateOneSection() {
		    
		    // given
		    Iterator<Section> sections;
		    
		    // when
		    sections = course.sectionsIterator();
		    
		    // then
		    assertAll("Verify Iterator contents",
		                    () -> assertTrue(sections.hasNext(), "Should has next section"),
		                    () -> assertSame("Section should be OK", section0, sections.next()),
		                    () -> assertFalse(sections.hasNext(), "Should not have another section"));
		}
		
		@Test
		void should_ContainAllSections_When_CreateSeveralSections() {
		    
            // given
            Section section1 = course.createSection("Spring 2023", "Room 1", "Mon.17:00");
            Section section2 = course.createSection("Summer 2023", "Room 2", "Tue.17:00");
            Set<Section> sections = new HashSet<>();
            int expectedSize = 3;
            
            // when
            Iterator<Section> iterator = course.sectionsIterator();
            iterator.forEachRemaining(section -> sections.add(section));
            
            
            // then
            assertAll("Verify Set contents",
                            () -> assertEquals(expectedSize, sections.size(), "Should have expected size"),
                            () -> assertTrue(sections.contains(section0), "Section 0 should be in set"),
                            () -> assertTrue(sections.contains(section1), "Section 1 should be in set"),
                            () -> assertTrue(sections.contains(section2), "Section 2 should be in set"));
		}
		
		
	}
	
	@Nested
	class GetUncompleteSectionsTests {

		@Test
		void should_Return1UncompleteSection_When_OnlyOneSectionInCourse() {
		    
		    // given
		    int expectedSize = 1;
		    
		    // when
		    List<Section> vacantSections = course.getUncompleteSections();
		    
		    // then
            assertAll( "Check vacant sections",
                            () -> assertTrue(vacantSections.contains(section0), "Section 0 should be in list"),
                            () -> assertEquals(expectedSize, vacantSections.size(), "Size should be as expected"));
		}
		
        @Test
        void should_Return1UncompleteSection_When_OnlyOneUncompleteSectionInCourse() {
            
            // given
            Section section1 = course.createSection(SEMESTER, PLACE, DAYS_AND_TIMES);
            int section1Capacity = 8;
            int sectionCapacity = 12;
            section0.setCapacity(sectionCapacity);
            section0.setNumOfStudentsEnrolled(sectionCapacity);
            section1.setCapacity(section1Capacity);
            section1.setNumOfStudentsEnrolled(section1Capacity - 3);
            int expectedSize = 1;
            
            // when
            List<Section> vacantSections = course.getUncompleteSections();
            
            // then
            assertAll( "Check vacant sections",
                            () -> {
                                String message = "Size should be as expected";
                                assertEquals(expectedSize, vacantSections.size(), message);
                            },
                            () -> {
                                String message = "Section 0 should not be in list";
                                assertFalse(vacantSections.contains(section0), message);
                            },
                            () -> {
                                String message = "Section 1 should be in list";
                                assertTrue(vacantSections.contains(section1), message);
                            });
        }
        
        @Test
        void should_ReturnCorrectSections_When_SeveralUncompleteSections() {

            // given
            Section section1 = course.createSection(SEMESTER, PLACE, DAYS_AND_TIMES);
            Section section2 = course.createSection(SEMESTER, PLACE, DAYS_AND_TIMES);
            Section section3 = course.createSection(SEMESTER, PLACE, DAYS_AND_TIMES);
            section0.setNumOfStudentsEnrolled(Section.DEFAULT_SECTION_CAPACITY);
            section2.setNumOfStudentsEnrolled(Section.DEFAULT_SECTION_CAPACITY);
            int expectedSize = 2;
            
            // when
            List<Section> secs = course.getUncompleteSections();
            
            // then
            assertAll("Verify Uncomplete Sections",
                            () -> assertEquals(expectedSize, secs.size(), "Should have expected size" ),
                            () -> assertFalse(secs.contains(section0)),
                            () -> assertTrue(secs.contains(section1)),
                            () -> assertFalse(secs.contains(section2)),
                            () -> assertTrue(secs.contains(section3))
                            );
        }
        
	}
	
}
