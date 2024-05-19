package com.harshit.learningmanagementsystem.controller;

import com.harshit.learningmanagementsystem.dto.StudentRequestDto;
import com.harshit.learningmanagementsystem.entity.Student;
import com.harshit.learningmanagementsystem.entity.Subject;
import com.harshit.learningmanagementsystem.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(StudentController.APPLICATION_ENDPOINT)
public class StudentController {
    protected static final String APPLICATION_ENDPOINT = "/learning-navigator/api/v1";
    private static final String STUDENT_ENDPOINT = "students";

    @Autowired
    private IStudentService studentService;

    @PostMapping(STUDENT_ENDPOINT)
    public ResponseEntity<Student> addStudent(@RequestBody @Valid StudentRequestDto studentRequestDto){
        retutn null;
    }

    @GetMapping(STUDENT_ENDPOINT)
    public ResponseEntity<List<Student>> getStudents(){
        return
    }

    @GetMapping(STUDENT_ENDPOINT+"/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        return
    }

    @PutMapping(STUDENT_ENDPOINT+"/{id}")
    public ResponseEntity<Student> updateStudentById(){
        return
    }

    @DeleteMapping(STUDENT_ENDPOINT+"/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long id){
        return
    }

    @PutMapping
    public ResponseEntity<Student> enrollStudentInSubject(@RequestBody List<Long> subjectIds){

    }
}
