package com.example.gradetracker_pj1.model;
import android.app.Application;

import java.util.List;

import androidx.core.provider.FontsContractCompat;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GradeDao {
    @Query("select * from User")
    List<User> getAllUsers();

    @Query("select * from Assignment")
    List<Assignment> getAllAssignments();

    @Query("select * from Grade")
    List<Grade> getAllGrades();

    @Query("select * from Course")
    List<Course> getAllCourses();

    @Query("select * from GradeCategory")
    List<Course> getAllGradeCategorys();

    @Query("select * from Enrollment")
    List<Enrollment> getAllEnrollments();

    @Query("select * from User where username =:username and password=:password ")
    User loginUser(String username, String password);

    @Query("select * from Course where course_id=:course_id")
    Course searchCourse(int course_id);

    @Query("select * from Assignment where assignment_id=:assignment_id")
    Assignment searchAssignment(int assignment_id);

    @Query("select * from Grade where grade_id=:grade_id and student_id =:student_id and assignment_id =:assignment_id")
    Grade searchGrade(int grade_id, int student_id,int assignment_id);

    @Query("select * from GradeCategory where grade_id=:grade_id and category_id=:category_id ")
    GradeCategory searchGradeCategory(int grade_id , int category_id);
    @Insert
    void addAssignment(Assignment assignment);
    @Insert
    void addCourse(Course course);
    @Insert
    void addEnrollment(Enrollment enrollment);
    @Insert
    void addGrade(Grade grade);
    @Insert
    void addGradeCategory(GradeCategory gradeCategory);
    @Insert
    void addUser(User user);

    @Delete
    void deleteCourse(Course course);

    @Delete
    void deleteGrade(Grade grade);

    @Delete
    void deleteEnrollment(Enrollment enrollment);

    @Delete
    void deleteAssignment(Assignment assignment);
}
