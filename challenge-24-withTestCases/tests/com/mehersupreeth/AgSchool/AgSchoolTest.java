package com.mehersupreeth.AgSchool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgSchoolTest {
//    List<Student> studentList;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
//        studentList.clear();
    }

    @Test
    void calculateTotalMarks() {
        List<Student> studentList = Arrays.asList(new Student("Meher", 123, 85, 90, 50, 68, 82),
                new Student("Mallesh", 234, 43, 89, 52, 61, 48),
                new Student("Anindya", 345, 83, 88, 65, 60, 82),
                new Student("Lokesh", 456, 48, 72, 80, 69, 90),
                new Student("Vnnkat", 567, 70, 91, 55, 70, 82)
        );
        AgSchool ags = new AgSchool();
        List<Float> actualOutput = ags.calculateTotalMarks(studentList);
        List<Float> expectedOutput = Arrays.asList(75f, 58.6f, 75.6f, 71.8f, 73.6f);
        assertNotSame(expectedOutput, actualOutput);
    }

    @Test
    void calculateTopper() {
        List<Student> studentList = Arrays.asList(new Student("Meher", 123, 85, 90, 50, 68, 82),
                new Student("Mallesh", 234, 43, 89, 52, 61, 48),
                new Student("Anindya", 345, 83, 88, 65, 60, 82),
                new Student("Lokesh", 456, 48, 72, 80, 69, 90),
                new Student("Vnnkat", 567, 70, 91, 55, 70, 82)
        );
        AgSchool ags = new AgSchool();
        String actualOutput = ags.calculateTopper(studentList);
        String expectedOutput = "Meher,123";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void averageMarksInEachSubject() {
    }

    @Test
    void assignGrades() {
    }
}