package com.harshit.learningmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private long id;

    @NonNull
    @OneToOne
    private Subject subject;


    @ManyToMany
    private List<Student> students;
}
