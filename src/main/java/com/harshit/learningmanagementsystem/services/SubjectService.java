package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.dto.RegisterStudentInSubjectRequestDto;
import com.harshit.learningmanagementsystem.dto.SubjectRequestDto;
import com.harshit.learningmanagementsystem.entity.Student;
import com.harshit.learningmanagementsystem.entity.Subject;
import com.harshit.learningmanagementsystem.exceptions.StudentNotFoundException;
import com.harshit.learningmanagementsystem.exceptions.SubjectNotFoundException;
import com.harshit.learningmanagementsystem.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService{

    @Autowired
    private IStudentService studentService;
    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject addSubject(SubjectRequestDto subjectRequestDto) {
        Subject subject = new Subject(subjectRequestDto.getName());
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubjectById(long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(!optionalSubject.isPresent())
            throw new SubjectNotFoundException("Subject with id "+id+ " doesn't exist");
        return optionalSubject.get();
    }

    @Override
    public Subject updateSubjectById(long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(!optionalSubject.isPresent())
            throw new SubjectNotFoundException("Subject with id "+id+ " doesn't exist");
        Subject subject = new Subject(id, optionalSubject.get().getName());
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubjectById(long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(!optionalSubject.isPresent())
            throw new SubjectNotFoundException("Subject with id "+id+ " doesn't exist");
        subjectRepository.delete(optionalSubject.get());
    }

    @Override
    public Subject registerStudentInSubject(long subjectId, RegisterStudentInSubjectRequestDto dto) {
        long studentId = dto.getStudentId();
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        if(!optionalSubject.isPresent())
            throw new SubjectNotFoundException("Subject with id "+subjectId+ " doesn't exist");

       Student student = studentService.getStudentById(studentId);
       Subject subject = optionalSubject.get();
       subject.addStudentToSubject(student);

        return subjectRepository.save(subject);
    }
}
