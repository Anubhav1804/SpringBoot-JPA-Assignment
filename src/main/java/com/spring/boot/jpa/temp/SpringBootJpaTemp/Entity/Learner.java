package com.spring.boot.jpa.temp.SpringBootJpaTemp.Entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "get_all_learner", query = "SELECT l FROM Learner l")
@Table(name = "Learner")
public class Learner {

    @Id
    @GeneratedValue
    private int Id;

    //@Column(name = "FirstName")
    private String FirstName;

    //@Column(name = "LastName")
    private String LastName;

    //@Column(name = "Email")
    private String Email;

    //@Column(name = "Password")
    private String Password;

    //@Column(name = "CourseId")
    //private int CourseId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CourseId", referencedColumnName = "Id")
    private Course course;

    public Learner() {}

    public Learner(int id, String firstName, String lastName, String email, String password, Course course) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        this.course = course;
    }

    public Learner(int id, String firstname, String lastName, String email, String password) {
        Id = id;
        FirstName = firstname;
        LastName = lastName;
        Email = email;
        Password = password;
    }

    public Learner(String firstName, String lastName, String email, String password, Course course) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        this.course = course;
    }

    public Learner(String firstname, String lastName, String email, String password) {
        FirstName = firstname;
        LastName = lastName;
        Email = email;
        Password = password;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstname) {
        FirstName = firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Learner{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", course=" + course +
                '}';
    }
}
