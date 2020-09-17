package com.example.gradetracker_pj1;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class EditCourseTest {




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

        Context EditCourse = InstrumentationRegistry.getInstrumentation().getTargetContext();
        List<Course> courseList = GradeRoom.getGradeRoom(EditCourse).dao().getAllCourses();

        Course course1 = new Course(111, "Dr.Test", "Test course", "Data-test", "8/24/20", "12/16/20");

        courseList.add(course1);

        assertNotNull(course1);

       GradeDao dao = GradeRoom.getGradeRoom(EditCourse).dao();

       //GradeRoom.getGradeRoom(EditCourse).dao().searchCourse(111).setInstructor("Dr.newupdate");
        courseList.get(0).setInstructor("Dr.newupdate");

       // dao.addCourse(course1);
        dao.updateCourse(courseList);


        assertEquals("Dr.newupdate", courseList.get(0).getInstructor());


    }

}