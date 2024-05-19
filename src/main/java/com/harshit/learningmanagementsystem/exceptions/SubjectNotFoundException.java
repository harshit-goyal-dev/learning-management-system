package com.harshit.learningmanagementsystem.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SubjectNotFoundException extends RuntimeException{
    public SubjectNotFoundException(String message){
        super(message);
    }
}