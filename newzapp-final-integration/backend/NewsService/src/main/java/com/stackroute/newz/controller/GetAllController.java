package com.stackroute.newz.controller;

import com.stackroute.newz.repository.UserNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/getAllNews")
public class GetAllController {

    @Autowired
    private UserNewsRepository userNewsRepository;

    @GetMapping
    public ResponseEntity<?> getAllNews() {
        return new ResponseEntity<>(userNewsRepository.findAll(), HttpStatus.OK);
    }

}
