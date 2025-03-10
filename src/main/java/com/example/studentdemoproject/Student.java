package com.example.studentdemoproject;

import java.time.LocalDate;

public class Student {
    private int id;
    private float cgpa;
    private LocalDate DOB;
    private String name, major, gender, skills;

    public Student() {

    }

    public Student(int id, float cgpa, LocalDate DOB, String name, String major, String gender, String skills) {
        this.id = id;
        this.cgpa = cgpa;
        this.DOB = DOB;
        this.name = name;
        this.major = major;
        this.gender = gender;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", cgpa=" + cgpa +
                ", DOB=" + DOB +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", gender='" + gender + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
