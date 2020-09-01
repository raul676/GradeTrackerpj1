package com.example.gradetracker_pj1.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity
public class Enrollment {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int course_id;
    @NonNull
    private int student_id;
    @NonNull
    private String enrollment_date;

    public Enrollment(){}
    @Ignore
    public Enrollment(int course_id, int student_id, String enrollment_date){
        this.course_id= course_id;
        this.student_id = student_id;
        this.enrollment_date = enrollment_date;
    }

    public void setEnrollment_date(@NonNull String enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    @NonNull
    public String getEnrollment_date() {
        return enrollment_date;
    }

}
