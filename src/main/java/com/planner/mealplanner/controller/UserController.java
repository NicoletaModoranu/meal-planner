package com.planner.mealplanner.controller;

import com.planner.mealplanner.dto.UserBaseDTO;
import com.planner.mealplanner.dto.UserDTO;
import com.planner.mealplanner.mapper.UserMapper;
import com.planner.mealplanner.model.User;
import com.planner.mealplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> all() {
        return new ResponseEntity<>(userService.getAllUsers().stream().map(user -> userMapper.userToUserDTO(user)).toList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserBaseDTO> newUser(@RequestBody UserBaseDTO userDto) {
        User savedUser = userService.save(UserMapper.userBaseDTOToUser(userDto));
        return new ResponseEntity<>(userMapper.userToUserDTO(savedUser), HttpStatus.OK);
    }
}
