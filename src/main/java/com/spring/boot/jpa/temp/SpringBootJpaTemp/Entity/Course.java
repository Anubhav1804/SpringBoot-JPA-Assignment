package com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    //@GeneratedValue
    private int Id;

    private String CourseName;
    private String Description;

    public Course() {
    }

    public Course(int id, String courseName, String description) {
        Id = id;
        CourseName = courseName;
        Description = description;
    }

    public Course(String courseName, String description) {
        CourseName = courseName;
        Description = description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + Id +
                ", CourseName='" + CourseName + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}


