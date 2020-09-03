package com.example.gradetracker_pj1.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity
public class GradeCategory {
    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int category_id;
    private int grade_id;
    private double weight;
    private String title;
    private String assigned_date;

    public GradeCategory(){}

    @Ignore
    public GradeCategory(int category_id, int grade_id, double weight, String title, String assigned_date){
        this.category_id= category_id;
        this.grade_id = grade_id;
        this.weight = weight;
        this.title = title;
        this.assigned_date =assigned_date;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public void setAssigned_date(String assigned_date) {
        this.assigned_date = assigned_date;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public String getAssigned_date() {
        return assigned_date;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getTitle() {
        return title;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Grade Title: " + title + "\n" +
                "Weight: " + weight + "\n" +
                "Grade ID: " + grade_id;
    }
}
