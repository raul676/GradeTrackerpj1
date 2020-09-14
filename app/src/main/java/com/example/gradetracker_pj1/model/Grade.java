package com.example.gradetracker_pj1.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity
public class Grade {
    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int grade_tracker;
    @NonNull
    private int grade_id;
    @NonNull
    private int score;
    private int assignment_id;
    @NonNull
    private int course_id;
    @NonNull
    private int student_id;
    private String date_earned;

    public Grade(){}
    @Ignore
    public Grade(int grade_tracker,int grade_id , int score, int assignment_id, int course_id, int student_id,String date_earned){
        this.grade_tracker = grade_tracker;
        this.grade_id = grade_id;
        this.score = score;
        this.assignment_id = assignment_id;
        this.course_id = course_id;
        this.student_id = student_id;
        this.date_earned = date_earned;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setGrade_tracker(int grade_tracker){this.grade_tracker = grade_tracker;}
    public int getGrade_tracker(){return grade_tracker;}
    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public void setDate_earned(String date_earned) {
        this.date_earned = date_earned;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public int getScore() {
        return score;
    }

    public String getDate_earned() {
        return date_earned;
    }

    @Override
    public String toString() {
        return "Grade Score: " +score + "\n" +
                "Date Earned: " +date_earned + "\n" +
                "Student ID: " +student_id;
    }
}
