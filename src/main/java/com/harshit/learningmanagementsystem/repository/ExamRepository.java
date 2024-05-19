package com.harshit.learningmanagementsystem.repository;

import com.harshit.learningmanagementsystem.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
