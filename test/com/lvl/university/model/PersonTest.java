package com.lvl.university.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void test() {
        
        // given
        Student john = new Student("John");
        Employee jack = new Employee("Jack");
        
        // when
        jack.setName("Peter", john);
        
        // then
        assertEquals("Peter", john.getName());
    }

}
