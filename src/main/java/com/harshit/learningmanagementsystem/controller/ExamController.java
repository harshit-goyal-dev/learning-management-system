package com.harshit.learningmanagementsystem.controller;

import com.harshit.learningmanagementsystem.dto.EnrollStudentInExamRequestDto;
import com.harshit.learningmanagementsystem.dto.ExamRequestDto;
import com.harshit.learningmanagementsystem.dto.StudentRequestDto;
import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.entity.Student;
import com.harshit.learningmanagementsystem.services.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(ExamController.APPLICATION_ENDPOINT)
public class ExamController {
    protected static final String APPLICATION_ENDPOINT = "/learning-navigator/api/v1";
    private static final String EXAM_ENDPOINT = "exams";

    @Autowired
    private IExamService examService;
    @PostMapping(EXAM_ENDPOINT)
    public ResponseEntity<Exam> addExam(@RequestBody @Valid ExamRequestDto examRequestDto){
        return ResponseEntity.ok().body(examService.addExam(examRequestDto));
    }

    //enroll a student for a exam
    @PostMapping(EXAM_ENDPOINT+"/{examId}")
    public ResponseEntity<Exam> addExam(@PathVariable long examId
            , @RequestBody @Valid EnrollStudentInExamRequestDto dto){
        return ResponseEntity.ok().body(examService.enrollStudentInExam(examId,dto));
    }
    @GetMapping(EXAM_ENDPOINT)
    public ResponseEntity<List<Exam>> getExams(){
        return ResponseEntity.ok().body(examService.findAllExams());
    }

    @GetMapping(EXAM_ENDPOINT+"/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable long id){
        return ResponseEntity.ok().body(examService.getExamById(id));
    }

    @PutMapping(EXAM_ENDPOINT+"/{id}")
    public ResponseEntity<Exam> updateExamById(@PathVariable long id,@RequestBody @Valid ExamRequestDto examRequestDto){
        return ResponseEntity.ok().body(examService.updateExamById(id,examRequestDto));

    }
    @DeleteMapping(EXAM_ENDPOINT+"/{id}")
    public ResponseEntity<String> deleteExamById(@PathVariable long id){
        examService.deleteExamById(id);
        return ResponseEntity.ok().body("Deleted Successfully");

    }
}
