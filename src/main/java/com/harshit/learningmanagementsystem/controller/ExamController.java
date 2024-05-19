package com.harshit.learningmanagementsystem.controller;

import com.harshit.learningmanagementsystem.dto.StudentRequestDto;
import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(ExamController.APPLICATION_ENDPOINT)
public class ExamController {
    protected static final String APPLICATION_ENDPOINT = "/learning-navigator/api/v1";
    private static final String EXAM_ENDPOINT = "exams";


    @PostMapping(EXAM_ENDPOINT)
    public ResponseEntity<Exam> addExam(@RequestBody @Valid StudentRequestDto studentRequestDto){
        retutn null;
    }

    //register a student for a exam
    @PostMapping(EXAM_ENDPOINT+"/{examId}")
    public ResponseEntity<Exam> addExam(@PathVariable long examId){
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
