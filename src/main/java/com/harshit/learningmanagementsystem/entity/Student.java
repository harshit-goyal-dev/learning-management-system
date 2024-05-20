package com.harshit.learningmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;

    @NonNull
    private String name;

    @ManyToMany(mappedBy = "students")
    @JsonBackReference
    //@JsonManagedReference
    private List<Exam> exams;

    @ManyToMany(mappedBy = "students")
    @JsonBackReference
    //@JsonManagedReference
    private List<Subject> subjects;

    public Student(@NonNull String name) {
        this.name = name;
        //
        this.exams=new ArrayList<>();
        this.subjects = new ArrayList<>();
    }

    public Student(long id, @NonNull String name) {
        this(name);
        this.id = id;
    }
}
