package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.entity.Subject;
import com.harshit.learningmanagementsystem.repository.ExamRepository;
import com.harshit.learningmanagementsystem.repository.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SubjectServiceTest {
    @InjectMocks
    private ISubjectService subjectService;

    @MockBean
    private SubjectRepository subjectRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getAllSubjects(){
        List<Subject> subjects = Arrays.asList(new Subject("Maths"), new Subject("English"));

        when(subjectRepository.findAll()).thenReturn(subjects);
        List<Subject> subjectList = subjectService.findAllSubjects();
        assertEquals(2, subjectList.size());
        assertEquals("Maths", subjectList.get(0).getName());
    }
}
