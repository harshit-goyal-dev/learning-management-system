package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.entity.Subject;
import com.harshit.learningmanagementsystem.repository.ExamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ExamServiceTest {
    @InjectMocks
    private IExamService examService;

    @MockBean
    private ExamRepository examRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getAllExams(){
        Subject subject1 = new Subject(1,"Maths");
        Subject subject2 = new Subject(2,"English");

        List<Exam> exams = Arrays.asList(new Exam(1,subject1), new Exam(2,subject2));

        when(examRepository.findAll()).thenReturn(exams);
        List<Exam> examList = examService.findAllExams();
        assertEquals(2, examList.size());
        assertEquals(1, examList.get(0).getId());
    }


}
