package com.example.Example.user.service;

import com.example.Example.user.assembler.CommentAssembler;
import com.example.Example.user.assembler.CoursesAssembler;
import com.example.Example.user.model.*;
import com.example.Example.user.repo.CoursesRepository;
import com.example.Example.user.repo.UserRepository;
import com.example.Example.user.repo.CommentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursesService {

    private final CoursesRepository coursesRepository;
    private final CoursesAssembler coursesAssembler;
    private final CommentAssembler commentAssembler;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final UserService userService;


    public CoursesService(CoursesRepository coursesRepository, CoursesAssembler coursesAssembler, CommentAssembler commentAssembler, UserRepository userRepository, CommentRepository commentRepository, UserService userService) {
        this.coursesRepository = coursesRepository;
        this.coursesAssembler = coursesAssembler;
        this.commentAssembler = commentAssembler;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    public Courses findById(Integer id) {
        return coursesRepository.findById(id)
                .orElse(null);
    }

    public List<CoursesDto> getAllCourses() {
        List<Courses> courses = coursesRepository.findAll();
        return courses.stream()
                .map(coursesAssembler::map)
                .collect(Collectors.toList());
    }

    public CoursesDto getCourseById(Integer courseId) {
        Courses course = coursesRepository.findById(courseId)
                .orElse(null);
        return coursesAssembler.map(course);
    }

    public List<Comment> getCommentsForCourse(Integer courseId) {
        Courses course = coursesRepository.findById(courseId)
                .orElse(null);
        return course.getComments();
    }

    public CoursesDto addComment(Integer courseId, CommentDto commentDto) {
        Courses course = coursesRepository.findById(courseId).orElse(null);;

        Comment comment = commentAssembler.update(commentDto);
        comment.setCourse(course);
        commentRepository.save(comment);

        course.getComments().add(comment);
        coursesAssembler.map(course);
        coursesRepository.save(course);

        return null;
    }




}

