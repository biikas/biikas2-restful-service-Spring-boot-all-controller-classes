package com.springboot.springrestfulserviceexample2.controller;

import com.springboot.springrestfulserviceexample2.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@Slf4j
@RequestMapping("student")
public class StudentController {

    @PostMapping(value = "add")
    public ResponseEntity<String> add(@RequestBody Student student){
    String s = student.getId()+student.getUsername()+student.getPassword();
    return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    //display student object
    @GetMapping(value = "array")
    public ResponseEntity<List<Student>> displayArrayObject(){
        Student student= new Student();
        student.setId(1);
        student.setUsername("bikas1921");
        student.setPassword("1234");

        List<Student> students = new ArrayList<>();
        students.add(student);
        return new ResponseEntity<>(students,HttpStatus.ACCEPTED);
    }
    @PostMapping(value = "create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        log.info("Create method called");
        Random random = new Random();
// Generates random integers 0 to 49
        int x = random.nextInt(50);
        student.setId(x);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token",String.valueOf(student.getId()));
        return new ResponseEntity<>(student,httpHeaders,HttpStatus.CREATED);
    }

}
