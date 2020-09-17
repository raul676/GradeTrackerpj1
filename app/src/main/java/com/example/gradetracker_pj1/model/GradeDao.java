package com.example.gradetracker_pj1.model;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GradeDao {
    @Query("select * from User")
    List<User> getAllUser();

    @Query("select * from Assignment")
    List<Assignment> getAllAssignments();

    @Query("select * from Grade")
    List<Grade> getAllGrades();

    @Query("select * from Course")
    List<Course> getAllCourses();

    @Query("select * from GradeCategory")
    List<GradeCategory> getAllGradeCategorys();

    @Query("select * from Enrollment")
    List<Enrollment> getAllEnrollments();

    @Query("select * from User where username =:username and password=:password ")
    User loginUser(String username, String password);

    @Query("select * from Course where course_id=:course_id")
    Course searchCourse(int course_id);

    //edit course
    @Query("select * from Course where course_id=:course_id")
    List<Course> searchCourse2(int course_id);

    @Query("select * from Assignment where assignment_id=:assignment_id")
    List<Assignment> searchAssignment(int assignment_id);

    @Query("select * from Assignment where assignment_id=:assignment_id")
    Assignment searchAssignment2(int assignment_id);

    @Query("select * from Grade where course_id =:course_id and student_id =:student_id")
    List<Grade> searchGrades(int course_id, int student_id);

    @Query("select * from Grade where course_id=:course_id and student_id =:student_id")
    Grade searchGrade(int course_id, int student_id);

    @Query("select * from Grade where course_id=:course_id")
    List<Grade> searchGrades_toDelete(int course_id);

    @Query("select * from Enrollment where course_id =:course_id and student_id =:student_id")
    Enrollment searchEnrollment(int course_id, int student_id);

    @Query("select * from GradeCategory where course_id=:course_id ")
    List<GradeCategory> searchGradeCategorys_to_deltet(int course_id );

    @Query("select * from GradeCategory where course_id=:course_id ")
    List<GradeCategory> searchGradeCategory(int course_id );

    @Query("select * from Enrollment where  student_id=:student_id")
    List <Enrollment> searchEnrolledCourse( int student_id );

    @Query("select * from Enrollment where  course_id=:course_id")
    List <Enrollment> searchEnrolledCourses_to_delete( int course_id );

    @Query("select * from Assignment where course_id=:course_id")
    List<Assignment> searchAssignment_to_delete(int course_id);

    @Query("select * from User where userid=:user_id")
    User searchUser(int user_id);


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
    void deleteEnrollments(List<Enrollment> enrollment);

    @Delete
    void deleteAssignment(Assignment assignment);

    @Delete
    void deleteGrades(List<Grade> grades);

    @Delete
    void deleteAssignments(List<Assignment> assignments);
    @Delete
    void deleteGradeCategorys(List<GradeCategory> gradeCategories);
    @Update
    void updateAssignment(List<Assignment> assignments);
    @Update
    void updateCourse(List<Course> courses);




}
