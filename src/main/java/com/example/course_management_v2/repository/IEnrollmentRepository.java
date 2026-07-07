package com.example.course_management_v2.repository;

import com.example.course_management_v2.model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface IEnrollmentRepository {
    List<Enrollment> findAll();

    Optional<Enrollment> findById(Long id);

    Optional<Enrollment> create(Enrollment enrollment);

    Optional<Enrollment> update(Long id, Enrollment enrollment);

    Optional<Enrollment> deleteById(Long id);
}
