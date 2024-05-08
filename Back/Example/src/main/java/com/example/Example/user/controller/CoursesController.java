package com.example.Example.user.controller;

import com.example.Example.user.model.Comment;
import com.example.Example.user.model.CommentDto;
import com.example.Example.user.model.Courses;
import com.example.Example.user.model.CoursesDto;
import com.example.Example.user.service.CoursesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/courses")
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping("/{courseId}")
    public CoursesDto getCourseById(@PathVariable Integer courseId) {
        return coursesService.getCourseById(courseId);
    }

    @GetMapping("/{courseId}/comments")
    public List<Comment> getCommentsForCourse(@PathVariable Integer courseId) {
        return coursesService.getCommentsForCourse(courseId);
    }

    @PostMapping("/{courseId}/comments")
    public ResponseEntity<CoursesDto> addComment(@PathVariable Integer courseId, @RequestBody CommentDto commentDto) {
        CoursesDto updatedCourse = coursesService.addComment(courseId, commentDto);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CoursesDto>> getAllCourses() {
        List<CoursesDto> courses = coursesService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

}
