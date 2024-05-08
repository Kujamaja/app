package com.example.Example.user.model;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;


    @OneToMany(targetEntity = Courses.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Courses> courses;

    public User() {}

    public User(String firstName, String lastName, Integer age) {
        this.username = firstName;
        this.password = lastName;

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public void addCourse(Courses cours) {
        this.courses.add(cours);
    }
}

