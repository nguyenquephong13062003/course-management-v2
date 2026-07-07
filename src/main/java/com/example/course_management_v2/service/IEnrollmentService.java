package com.example.course_management_v2.service;

import com.example.course_management_v2.model.Enrollment;

import java.util.List;

public interface IEnrollmentService {
    List<Enrollment> getAllEnrollment();

    Enrollment getEnrollmentById(Long id);

    Enrollment createEnrollment(Enrollment enrollment);

    Enrollment updateEnrollment(Long id, Enrollment enrollment);

    Enrollment deleteEnrollmentById(Long id);
}
