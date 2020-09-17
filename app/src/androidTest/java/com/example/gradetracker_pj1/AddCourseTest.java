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
public class AddCourseTest {

    private GradeDao dao;
    /** A unit test to test add course by checking the values of the new course by
     * asserting the values are equal
     */
    @Test
    public void onCreate() {

        Course course = new Course( 0001,"smith","art", "Least favorite class", "01-01-2021", "06/01/2021");
        assertEquals(0001,course.getCourse_id());
        assertEquals("smith", course.getInstructor());
        assertEquals("art", course.getCourse_title());
        assertEquals("Least favorite class", course.getDescription());
        assertEquals("01-01-2021", course.getStart_date());
        assertEquals("06/01/2021", course.getEnd_date());

    }

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
        Context AddCourse = InstrumentationRegistry.getInstrumentation().getTargetContext();
        List<Course> courseList = GradeRoom.getGradeRoom(AddCourse).dao().getAllCourses();

        Course course1 = new Course(383, "Dr. Bruns", "Into to Data Science", "Data", "8/24/20", "12/16/20");

        courseList.add(course1);
        assertNotNull(course1);

        GradeDao dao = GradeRoom.getGradeRoom(AddCourse).dao();
        dao.addCourse(course1);

        assertTrue(!courseList.isEmpty());

    }

}

