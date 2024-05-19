package com.harshit.learningmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private long id;

    @NonNull
    private String name;

    @ManyToMany
    private List<Student> students;

}
