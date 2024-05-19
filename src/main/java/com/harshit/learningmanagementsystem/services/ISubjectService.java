package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.dto.ExamRequestDto;
import com.harshit.learningmanagementsystem.dto.RegisterStudentInSubjectRequestDto;
import com.harshit.learningmanagementsystem.dto.SubjectRequestDto;
import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.entity.Subject;

import java.util.List;

public interface ISubjectService {
    public List<Subject> findAllSubjects();

    public Subject addSubject(SubjectRequestDto subjectRequestDto);

    public Subject getSubjectById(long id);

    public Subject updateSubjectById(long id);

    public void deleteSubjectById(long id);

    public Subject registerStudentInSubject(long subjectId, RegisterStudentInSubjectRequestDto dto);
}
