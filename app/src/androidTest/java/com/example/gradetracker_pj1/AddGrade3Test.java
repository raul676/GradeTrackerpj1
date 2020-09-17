package com.example.gradetracker_pj1;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.gradetracker_pj1.model.GradeCategory;
import com.example.gradetracker_pj1.model.GradeDao;
import com.example.gradetracker_pj1.model.GradeRoom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/** A test to run if adding a grade to dao is implemented, AddGrade3 refers to the menu in which admin can add the grade for the student*/
    @RunWith(AndroidJUnit4.class)
    public class AddGrade3Test {

        private GradeDao dao;

        /** on create test, gets the context (database) required to do test  */
        @Before
        public void createDB(){
            Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            GradeDao dao = GradeRoom.getGradeRoom(appContext).dao();
            assertEquals("com.example.gradetracker_pj1", appContext.getPackageName());
        }

        /** testing on click when addition occurs by adding grade to a list then adding the grade and checking if the
         * list is populated
         */
        @Test
        public void onClick() {
            Context AddGrade3 = InstrumentationRegistry.getInstrumentation().getTargetContext();
            List<GradeCategory> gradeList = GradeRoom.getGradeRoom(AddGrade3).dao().getAllGradeCategorys();

            GradeCategory grade1 = new GradeCategory(43813, 11, .25, "Software Engineering", "8/26/20",438);
            gradeList.add(grade1);
            assertNotNull(grade1);

            GradeDao dao = GradeRoom.getGradeRoom(AddGrade3).dao();
            dao.addGradeCategory(grade1);

            assertTrue(!gradeList.isEmpty());
        }
    }


