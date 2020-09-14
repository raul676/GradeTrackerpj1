package com.example.gradetracker_pj1;

import com.example.gradetracker_pj1.model.Course;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddCourseTest {

    @Test
    public void onCreate() {
        Course course = new Course( 0000,"smith","art", "Least favorite class", "01-01-2021", "06/01/2021");
        assertEquals(0000,course.getCourse_id());
        assertEquals("smith", course.getInstructor());
        assertEquals("art", course.getCourse_title());
        assertEquals("least favorite class", course.getDescription());
        assertEquals("01/01/2010", course.getStart_date());
        assertEquals("06/01/2021", course.getEnd_date());


    }
}

