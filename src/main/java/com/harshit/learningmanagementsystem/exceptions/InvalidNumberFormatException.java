package com.harshit.learningmanagementsystem.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class InvalidNumberFormatException extends RuntimeException{
    public InvalidNumberFormatException(String message){
        super(message);
    }
}
