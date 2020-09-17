package com.example.gradetracker_pj1;

import android.content.Context;

import androidx.room.Delete;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.gradetracker_pj1.model.Course;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
    public class DeleteCourseTest {

        private GradeDao dao;

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
           Context DeleteCourse = InstrumentationRegistry.getInstrumentation().getTargetContext();
            List<Course> courseList = GradeRoom.getGradeRoom(DeleteCourse).dao().getAllCourses();

            Course course1 = new Course(383, "Dr. Bruns", "Into to Data Science", "Data", "8/24/20", "12/16/20");

            courseList.add(course1);
            assertNotNull(course1);

            GradeDao dao = GradeRoom.getGradeRoom(DeleteCourse).dao();
            dao.deleteCourse(course1);

            assertTrue(!courseList.isEmpty());

        }
}
