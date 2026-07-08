package com.example.course_management_v2.repository.jpa;

import com.example.course_management_v2.model.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEnrollmentRepository
        extends JpaRepository<StudentEnrollment,Long>{

}