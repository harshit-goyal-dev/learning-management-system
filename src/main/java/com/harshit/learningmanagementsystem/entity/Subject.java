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
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private long id;

    @NonNull
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    //@JsonBackReference
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
