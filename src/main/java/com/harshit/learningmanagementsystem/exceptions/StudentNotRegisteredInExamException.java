package com.harshit.learningmanagementsystem.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudentNotRegisteredInExamException extends RuntimeException{
    public StudentNotRegisteredInExamException(String message){
        super(message);
    }
}
