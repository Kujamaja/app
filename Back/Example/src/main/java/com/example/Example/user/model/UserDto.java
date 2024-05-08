package com.example.Example.user.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private List<CoursesDto> courses = new ArrayList<>();

    public List<CoursesDto> getCourses() {
        return courses;
    }
}

