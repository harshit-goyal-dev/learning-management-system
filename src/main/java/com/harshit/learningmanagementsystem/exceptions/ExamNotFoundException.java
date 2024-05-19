package com.harshit.learningmanagementsystem.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ExamNotFoundException extends RuntimeException{
    public ExamNotFoundException(String message){
        super(message);
    }
}
