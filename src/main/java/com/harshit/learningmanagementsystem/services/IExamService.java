package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.dto.ExamRequestDto;
import com.harshit.learningmanagementsystem.entity.Exam;

import java.util.List;

public interface IExamService{
    public List<Exam> findAllExams();

    public Exam addExam(ExamRequestDto examRequestDto);

    public Exam getExamById(long id);

    public Exam updateExamById(long id);

    public void deleteExamById(long id);

    public void registerStudentInExam();

}
