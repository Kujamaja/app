package com.example.Example.user.controller;

import com.example.Example.user.model.CommentDto;
import com.example.Example.user.model.User;
import com.example.Example.user.model.UserDto;
import com.example.Example.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserDto> get() {
        return userService.getAll();
    }

    @GetMapping("user/{id}")
    public User get(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return user;
    }

    @DeleteMapping("user/{id}")
    public void delete(@PathVariable Integer id) {
        userService.remove(id);
    }

    @PostMapping()
    public User create(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("user/{id}")
    public User editCourses(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }




}
