package com.example.course_management_v2.repository.jpa;

import com.example.course_management_v2.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository
        extends JpaRepository<Course, Long> {

}