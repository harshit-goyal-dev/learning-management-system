package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.dto.EnrollStudentInExamRequestDto;
import com.harshit.learningmanagementsystem.dto.ExamRequestDto;
import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.entity.Student;
import com.harshit.learningmanagementsystem.entity.Subject;
import com.harshit.learningmanagementsystem.exceptions.ExamNotFoundException;
import com.harshit.learningmanagementsystem.exceptions.StudentNotEnrolledInSubjectException;
import com.harshit.learningmanagementsystem.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService implements IExamService{

    @Autowired
    private ISubjectService subjectService;

    @Autowired
    private IStudentService studentService;
    @Autowired
    private ExamRepository examRepository;
    @Override
    public List<Exam> findAllExams() {
        return examRepository.findAll();
    }

    @Override
    public Exam addExam(ExamRequestDto examRequestDto) {
        Subject subject = subjectService.getSubjectById(examRequestDto.getSubjectId());
        Exam exam = new Exam(subject);
        return examRepository.save(exam);
    }

    @Override
    public Exam getExamById(long id) {
        Optional<Exam> optionalExam = examRepository.findById(id);
        if(!optionalExam.isPresent())
            throw new ExamNotFoundException("Exam with id "+id+ " doesn't exist");

        return optionalExam.get();
    }

    @Override
    public Exam updateExamById(long id, ExamRequestDto examRequestDto) {
        Optional<Exam> optionalExam = examRepository.findById(id);
        if(!optionalExam.isPresent())
            throw new ExamNotFoundException("Exam with id "+id+ " doesn't exist");
        Subject subject = subjectService.getSubjectById(examRequestDto.getSubjectId());
        Exam exam = optionalExam.get();
        Exam updatedExam = new Exam(exam.getId(), subject, exam.getStudents());
        return examRepository.save(updatedExam);
    }

    @Override
    public void deleteExamById(long id) {
        Optional<Exam> optionalExam = examRepository.findById(id);
        if(!optionalExam.isPresent())
            throw new ExamNotFoundException("Exam with id "+id+ " doesn't exist");
        examRepository.delete(optionalExam.get());
    }

    @Override
    public Exam enrollStudentInExam(long examId, EnrollStudentInExamRequestDto dto) {
        Optional<Exam> optionalExam = examRepository.findById(examId);
        if(!optionalExam.isPresent())
            throw new ExamNotFoundException("Exam with id "+examId+ " doesn't exist");

        long studentId = dto.getStudentId();
        Student student = studentService.getStudentById(studentId);
        Exam exam = optionalExam.get();
        Subject subject = exam.getSubject();
        boolean b = studentService.isStudentEnrolledInSubject(studentId,subject.getId());
        if(!b)throw new StudentNotEnrolledInSubjectException("Student is not enrolled in the subject. Please enroll first and then register for exam");
        exam.addStudentToExam(student);
        return examRepository.save(exam);
    }
}
