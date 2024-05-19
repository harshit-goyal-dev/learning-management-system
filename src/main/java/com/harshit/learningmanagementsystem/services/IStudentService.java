package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.dto.ExamRequestDto;
import com.harshit.learningmanagementsystem.dto.StudentRequestDto;
import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.entity.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> findAllStudents();

    public Student addStudent(StudentRequestDto studentRequestDto);

    public Student getStudentById(long id);

    public Student updateStudentById(long id, StudentRequestDto studentRequestDto);

    public void deleteStudentById(long id);

    public boolean isStudentEnrolledInSubject(long studentId, long subjectId);


    }
