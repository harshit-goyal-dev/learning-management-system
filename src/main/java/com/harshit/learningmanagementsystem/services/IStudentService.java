package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.dto.ExamRequestDto;
import com.harshit.learningmanagementsystem.dto.StudentRequestDto;
import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.entity.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> findAllExams();

    public Student addStudent(StudentRequestDto studentRequestDto);

    public Student getStudentById(long id);

    public Student updateStudentById(long id);

    public void deleteStudentById(long id);


}
