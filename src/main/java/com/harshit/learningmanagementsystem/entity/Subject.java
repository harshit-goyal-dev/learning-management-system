package com.harshit.learningmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
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

    public Subject(@NonNull String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public Subject(long id, @NonNull String name) {
        this(name);
        this.id = id;
    }
    public void addStudentToSubject(Student student){
        this.students.add(student);
    }
}
