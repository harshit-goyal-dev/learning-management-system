package com.harshit.learningmanagementsystem.controller;

import com.harshit.learningmanagementsystem.dto.RegisterStudentInSubjectRequestDto;
import com.harshit.learningmanagementsystem.dto.StudentRequestDto;
import com.harshit.learningmanagementsystem.dto.SubjectRequestDto;
import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.entity.Subject;
import com.harshit.learningmanagementsystem.services.IStudentService;
import com.harshit.learningmanagementsystem.services.ISubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SubjectController.APPLICATION_ENDPOINT)
public class SubjectController {
    protected static final String APPLICATION_ENDPOINT = "/learning-navigator/api/v1";
    private static final String SUBJECT_ENDPOINT = "subjects";

    @Autowired
    private ISubjectService subjectService;
    @PostMapping(SUBJECT_ENDPOINT)
    public ResponseEntity<Subject> addSubject(@RequestBody @Valid SubjectRequestDto subjectRequestDto){
        return ResponseEntity.ok().body(subjectService.addSubject(subjectRequestDto));
    }

    //register a student in the subject
    @PostMapping(SUBJECT_ENDPOINT+"/{subjectId}")
    public ResponseEntity<Subject> registerStudentInSubject(@PathVariable long subjectId
            , @RequestBody RegisterStudentInSubjectRequestDto dto){
        return ResponseEntity.ok().body(subjectService.registerStudentInSubject(subjectId,dto));

    }
    @GetMapping(SUBJECT_ENDPOINT)
    public ResponseEntity<List<Subject>> getSubjects(){
        return ResponseEntity.ok().body(subjectService.findAllSubjects());
    }

    @GetMapping(SUBJECT_ENDPOINT+"/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable long id){
        return ResponseEntity.ok().body(subjectService.getSubjectById(id));
    }

    @PutMapping(SUBJECT_ENDPOINT+"/{id}")
    public ResponseEntity<Subject> updateSubjectById(@PathVariable long id){

        return ResponseEntity.ok().body(subjectService.updateSubjectById(id));
    }

    @DeleteMapping(SUBJECT_ENDPOINT+"/{id}")
    public ResponseEntity<String> deleteSubjectById(@PathVariable long id){
        subjectService.deleteSubjectById(id);
        return ResponseEntity.ok().body("Deleted Successfully");
    }
}
