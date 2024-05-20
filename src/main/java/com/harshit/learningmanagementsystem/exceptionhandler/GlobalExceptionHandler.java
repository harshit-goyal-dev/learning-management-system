package com.harshit.learningmanagementsystem.exceptionhandler;

import com.harshit.learningmanagementsystem.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException exception){
        return new ResponseEntity<String>("Student Not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<String> handleSubjectNotFoundException(SubjectNotFoundException exception){
        return new ResponseEntity<String>("Subject Not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExamNotFoundException.class)
    public ResponseEntity<String> handleExamNotFoundException(ExamNotFoundException exception){
        return new ResponseEntity<String>("Exam Not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentNotEnrolledInSubjectException.class)
    public ResponseEntity<String> handleStudentNotEnrolledInSubjectException(StudentNotEnrolledInSubjectException exception){
        return new ResponseEntity<String>(exception.getMessage().toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(StudentNotRegisteredInExamException.class)
    public ResponseEntity<String> handle(StudentNotRegisteredInExamException exception){
        return new ResponseEntity<String>(exception.getMessage().toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidNumberFormatException.class)
    public ResponseEntity<String> handle(InvalidNumberFormatException exception){
        return new ResponseEntity<String>(exception.getMessage().toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception exception){
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
