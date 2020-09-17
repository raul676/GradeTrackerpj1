package com.example.gradetracker_pj1;

import com.example.gradetracker_pj1.model.Assignment;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddAssignmentTest {

    /** A unit test to test add assignment by checking the values of the new assignment by
     * asserting the values are equal
     */
    @Test
    public void onCreate() {
        Assignment assignment = new Assignment(0001,0002,0003,100,"details","01/01/2021", "01/06/2021");

        assertEquals(0001, assignment.getAssignment_id());
        assertEquals(0002, assignment.getCourse_id());
        assertEquals(0003, assignment.getCategory_id());
        assertEquals(100, assignment.getMax_score());
      //  assertEquals(80, assignment.getEarned_score());
        assertEquals("details", assignment.getDetails());
        assertEquals("01/01/2021", assignment.getAssigned_date());
        assertEquals("01/06/2021", assignment.getDue_date());

    }
}
