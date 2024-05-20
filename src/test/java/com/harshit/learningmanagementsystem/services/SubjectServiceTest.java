package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.repository.ExamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

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
        List<Exam> exams = Arrays.asList(new Exam());

        when(userRepositoryService.findAll()).thenReturn(users);
        List<User> userList = userService.findAllUsers();
        assertEquals(2, userList.size());
        assertEquals("663e24e33a8b25270583c75d", userList.get(0).getId());
    }
}
