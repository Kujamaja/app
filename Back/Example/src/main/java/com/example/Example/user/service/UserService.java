package com.example.Example.user.service;

import com.example.Example.user.assembler.CommentAssembler;
import com.example.Example.user.assembler.CoursesAssembler;
import com.example.Example.user.assembler.UserAssembler;
import com.example.Example.user.model.*;
import com.example.Example.user.repo.CommentRepository;
import com.example.Example.user.repo.CoursesRepository;
import com.example.Example.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserAssembler userAssembler;
    private final UserRepository userRepository;
    private final CoursesAssembler coursesAssembler;
    private final CommentAssembler commentAssembler;
    private final CommentRepository commentRepository;
    private final CoursesRepository coursesRepository;

    public List<UserDto> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userAssembler::map)
                .collect(Collectors.toList());
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        userRepository.deleteById(id);
    }

    //public User create(User user) {return userRepository.save(user);}


    public User createUser(UserDto userDto) {
        User user = new User();
        List<Courses> courses = new ArrayList<>();
        

        userAssembler.update(user, userDto);

        List<CoursesDto> coursesDtos = userDto.getCourses();
        for (CoursesDto coursesDto : coursesDtos) {
            Courses cours = new Courses();
            coursesAssembler.update(coursesDto, cours);
            courses.add(cours);

        }

        
        user.setCourses(courses);
        //coursesAssembler.map();
        userAssembler.map(user);
        userRepository.save(user);

        return user;
    }

    public User update(UserDto userdto) {
        Integer id = userdto.getId();

        Optional<User> currentUser = userRepository.findById(id);
        if (currentUser.isPresent()) {
            User updatedUser = currentUser.get();
            userAssembler.update(updatedUser, userdto);
            updatedUser.setUsername(userdto.getUsername());
            updatedUser.setPassword(userdto.getPassword());

            userAssembler.map(updatedUser);
            userRepository.save(updatedUser);
            return updatedUser;
        }

        return null;

    }




}
