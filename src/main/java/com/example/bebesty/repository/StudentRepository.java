package com.example.bebesty.repository;

import com.example.bebesty.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    boolean findByEmail(String email);

}
