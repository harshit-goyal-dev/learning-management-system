package com.harshit.learningmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private long id;

    @NonNull
    @OneToOne
    private  Subject subject;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    //@JsonBackReference
    private List<Student> students;

    public Exam(@NonNull Subject subject) {
        this.subject = subject;
        this.students = new ArrayList<>();
    }

    public Exam(long id, @NonNull Subject subject) {
        this.id = id;
        this.subject = subject;
    }

    public void addStudentToExam(Student student){
        this.students.add(student);
    }
}
