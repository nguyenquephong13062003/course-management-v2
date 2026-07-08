package com.example.course_management_v2.repository.jpa;

import com.example.course_management_v2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student,Long>{

}