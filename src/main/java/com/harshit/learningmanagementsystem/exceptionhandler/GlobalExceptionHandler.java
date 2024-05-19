package com.harshit.learningmanagementsystem.exceptionhandler;

import com.harshit.learningmanagementsystem.exceptions.StudentNotFoundException;
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
}
