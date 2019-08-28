package com.oocl.web.sampleWebApp.controller;

import com.oocl.web.sampleWebApp.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<User>(){
        {
            add(new User("AAAA"));
            add(new User("11"));
        }
    };
    @GetMapping
    public ResponseEntity<List<User>> queryUsers(){
        return ResponseEntity.ok(users);
    }
    @PostMapping(consumes = "application/json")
    public ResponseEntity<User> addUser(@RequestBody User u){
        users.add(u);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
