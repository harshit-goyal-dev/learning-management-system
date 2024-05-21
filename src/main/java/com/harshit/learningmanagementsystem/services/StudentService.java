package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.dto.StudentRequestDto;
import com.harshit.learningmanagementsystem.entity.Student;
import com.harshit.learningmanagementsystem.entity.Subject;
import com.harshit.learningmanagementsystem.exceptions.StudentNotFoundException;
import com.harshit.learningmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student((studentRequestDto.getName()));
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) throws StudentNotFoundException{
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(!optionalStudent.isPresent())
            throw new StudentNotFoundException("Student with id "+id+ " doesn't exist");
        return optionalStudent.get();
    }

    @Override
    public Student updateStudentById(long id,StudentRequestDto studentRequestDto) {
        Student student = getStudentById(id);
        student.setName(studentRequestDto.getName());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }

    public boolean isStudentEnrolledInSubject(long studentId, long subjectId){
        Student student = getStudentById(studentId);
        Optional<Subject> optional = student.getSubjects().stream().filter(subject->subject.getId()==subjectId).findAny();
        if(optional.isEmpty())return false;
        return true;
    }
}
