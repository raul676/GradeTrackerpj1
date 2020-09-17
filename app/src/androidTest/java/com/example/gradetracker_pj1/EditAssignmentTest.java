package com.example.gradetracker_pj1;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EditAssignmentTest {




    /** on create test, gets the context (database) required to do test  */
    @Before
    public void createDB(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        GradeDao dao = GradeRoom.getGradeRoom(appContext).dao();
        assertEquals("com.example.gradetracker_pj1", appContext.getPackageName());
    }

    /** testing on click when deletion occurs by adding an course to a list then deleting course and checking if the
     * list is empty
     */
    @Test
    public void onClick() {

        Context EditAssignment = InstrumentationRegistry.getInstrumentation().getTargetContext();
        List<Assignment> assignmentsList = GradeRoom.getGradeRoom(EditAssignment).dao().getAllAssignments();

        Assignment assignment1 = new Assignment(0001,0002,0003,100,"details","01/01/2021", "01/06/2021");

        assignmentsList.add(assignment1);

        assertNotNull(assignment1);

        GradeDao dao = GradeRoom.getGradeRoom(EditAssignment).dao();


        assignmentsList.get(0).setDetails("update new details");


        dao.updateAssignment(assignmentsList);


        assertEquals("update new details", assignmentsList.get(0).getDetails());


    }
}