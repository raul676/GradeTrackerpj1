package com.example.gradetracker_pj1.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity
public class Course {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int course_id;
    @NonNull
    private String instructor;
    @NonNull
    private String course_title;
    @NonNull
    private String description;
    private String start_date;
    private String end_date;

    public Course(){}
    @Ignore
    public Course(int course_id,String instructor, String course_title, String description, String start_date, String end_date )
    {
        this.course_id = course_id;
        this.instructor = instructor;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.course_title = course_title;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setCourse_title(@NonNull String course_title) {
        this.course_title = course_title;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setInstructor(@NonNull String instructor) {
        this.instructor = instructor;
    }
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public int getCourse_id() {
        return course_id;
    }

    @NonNull
    public String getCourse_title() {
        return course_title;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public String getEnd_date() {
        return end_date;
    }

    @NonNull
    public String getInstructor() {
        return instructor;
    }

    public String getStart_date() {
        return start_date;
    }
    @Override

    public String toString()
    {
        return "Course Title: " + course_title + "\n" +
                "Course Instructor: " + instructor + "\n"+
                "Course Description: " + description + "\n" +
                "Course Start Date: " + start_date + "\n" +
                "Course End Date: " + end_date + "\n" +
                "Course ID: " + course_id;
    }

}
