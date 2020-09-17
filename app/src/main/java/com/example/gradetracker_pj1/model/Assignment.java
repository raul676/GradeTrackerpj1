package com.example.gradetracker_pj1.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Assignment {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int assignment_id;
    @NonNull
    private int course_id;
    @NonNull
    private int category_id;
    private int max_score;
    private String details;
    private String assigned_date;
    private String due_date;

    public Assignment(){}
    @Ignore
    public Assignment(int assignment_id, int course_id, int category_id, int max_score,
                      String details, String assigned_date,String due_date) {
        this.assignment_id = assignment_id;
        this.course_id = course_id;
        this.category_id = category_id;
        this.max_score = max_score;
        this.details = details;
        this.assigned_date = assigned_date;
        this.due_date = due_date;
    }
    public void setAssignment_id(@NonNull int assignment_id){this.assignment_id = assignment_id;}
    public void setCourse_id(@NonNull int course_id){this.course_id = course_id;}
    public void setCategory_id(@NonNull int category_id){this.category_id = category_id;}
    public void setMax_score(int max_score){this.max_score = max_score;}
    public void setDetails(String details){this.details = details;}
    public void setAssigned_date(String assigned_date){this.assigned_date = assigned_date;}
    public void setDue_date(String due_date) { this.due_date = due_date;}

    public int getAssignment_id() {
        return assignment_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getMax_score() {
        return max_score;
    }

    public String getAssigned_date() {
        return assigned_date;
    }

    public String getDetails() {
        return details;
    }

    public String getDue_date() {
        return due_date;
    }
    @Override
    public String toString()
    {
        return "Course ID: " + course_id + "\n"+
                "Assignment Details\n" +
                details + "\n" +
                "Max Score: " + max_score + "\n"+
                "Due Date: " + due_date + "\n"+

                "Assignment ID: " + assignment_id + "\n"+
                "Course Category ID: " + category_id;
    }
}
