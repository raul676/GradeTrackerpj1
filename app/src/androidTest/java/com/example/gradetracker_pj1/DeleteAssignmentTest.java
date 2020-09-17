
package com.example.gradetracker_pj1;

import android.content.Context;

import androidx.test.internal.runner.InstrumentationConnection;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.gradetracker_pj1.model.Assignment;
import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;
import com.example.gradetracker_pj1.model.User;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DeleteAssignmentTest {

    // private DeleteAssignment deleteAssignment;

    @Before
    public void createDB(){

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        GradeDao dao = GradeRoom.getGradeRoom(appContext).dao();
        assertEquals("com.example.gradetracker_pj1", appContext.getPackageName());
    }

    @Test
    public void OnClick() {

        Context deleteAssignment = InstrumentationRegistry.getInstrumentation().getTargetContext();

        List<Assignment> assignmentList =GradeRoom.getGradeRoom(deleteAssignment).dao().getAllAssignments();
        Assignment assignment1 = new Assignment(100, 10,1,10,"hello","09/20/20","12");
        assignmentList.add(assignment1);

        assertNotNull(assignment1);

        GradeDao dao = GradeRoom.getGradeRoom(deleteAssignment).dao();
        dao.deleteAssignment(assignment1);



        assertTrue(!assignmentList.isEmpty());
        //assertNull(assignment1);
        //private Context deleteAssignment = InstrumentationRegistry.getInstrumentation().getTargetContext();

    }
}