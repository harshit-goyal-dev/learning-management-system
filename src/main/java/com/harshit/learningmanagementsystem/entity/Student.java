package com.harshit.learningmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;

    @NonNull
    private String name;

    @ManyToMany
    private List<Exam> exams;

    @ManyToMany
    private List<Subject> subjects;
}
