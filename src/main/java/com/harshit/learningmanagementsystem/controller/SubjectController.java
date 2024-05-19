package com.harshit.learningmanagementsystem.controller;

import com.harshit.learningmanagementsystem.dto.StudentRequestDto;
import com.harshit.learningmanagementsystem.entity.Exam;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SubjectController.APPLICATION_ENDPOINT)
public class SubjectController {
    protected static final String APPLICATION_ENDPOINT = "/learning-navigator/api/v1";
    private static final String STUDENT_ENDPOINT = "subjects";

    @PostMapping(EXAM_ENDPOINT)
    public ResponseEntity<Exam> addExam(@RequestBody @Valid StudentRequestDto studentRequestDto){
        retutn null;
    }

    @GetMapping(EXAM_ENDPOINT)
    public ResponseEntity<List<Exam>> getExams(StudentRequestDto studentRequestDto){
        return
    }

    @GetMapping(EXAM_ENDPOINT+"/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable long id){
        return
    }

    @PutMapping(EXAM_ENDPOINT+"/{id}")
    public ResponseEntity<Exam> updateExamById(){
        return
    }

    @DeleteMapping(EXAM_ENDPOINT+"/{id}")
    public ResponseEntity<Exam> deleteExamById(@PathVariable long id){
        return
    }
}
