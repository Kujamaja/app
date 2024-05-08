package com.example.Example.user.assembler;

import com.example.Example.user.model.Courses;
import com.example.Example.user.model.CoursesDto;
import org.springframework.stereotype.Component;

@Component
public class CoursesAssembler {

    public CoursesDto map(Courses course) {
        CoursesDto dto = new CoursesDto();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setVideo(course.getVideo());
        dto.setComments(course.getComments());
        return dto;
    }

    public void update(CoursesDto courseDto, Courses course) {
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setVideo(courseDto.getVideo());
    }
}
