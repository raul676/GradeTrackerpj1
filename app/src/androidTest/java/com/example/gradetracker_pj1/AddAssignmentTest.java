package com.example.gradetracker_pj1;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class AddAssignmentTest {

    private GradeDao dao;

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
        assertEquals("details", assignment.getDetails());
        assertEquals("01/01/2021", assignment.getAssigned_date());
        assertEquals("01/06/2021", assignment.getDue_date());

    }
    /** on create test, gets the context (database) required to do test  */
    @Before
    public void createDB(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        GradeDao dao = GradeRoom.getGradeRoom(appContext).dao();
        assertEquals("com.example.gradetracker_pj1", appContext.getPackageName());
    }

    /** testing on click when addition occurs by adding an assignment to a list then adding the assignment and checking if the
     * list is populated
     */
    @Test
    public void onClick() {
        Context AddAssignment = InstrumentationRegistry.getInstrumentation().getTargetContext();
        List<Assignment> assignmentList = GradeRoom.getGradeRoom(AddAssignment).dao().getAllAssignments();

        Assignment assignment1 = new Assignment(0001,0002,0003,100,"details","01/01/2021", "01/06/2021");

        assignmentList.add(assignment1);
        assertNotNull(assignment1);

        GradeDao dao = GradeRoom.getGradeRoom(AddAssignment).dao();
        dao.addAssignment(assignment1);

        assertTrue(!assignmentList.isEmpty());
    }
}
