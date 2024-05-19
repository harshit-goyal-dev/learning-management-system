package com.harshit.learningmanagementsystem.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudentNotEnrolledInSubjectException extends RuntimeException{
    public StudentNotEnrolledInSubjectException(String message){
        super(message);
    }
}
