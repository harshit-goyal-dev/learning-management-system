package com.harshit.learningmanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.harshit.learningmanagementsystem.entity.Exam;
import com.harshit.learningmanagementsystem.entity.Subject;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {
    @NonNull
    private long id;

    @NonNull
    private String name;


    private List<Exam> exams;

    private List<Subject> subjects;

}
