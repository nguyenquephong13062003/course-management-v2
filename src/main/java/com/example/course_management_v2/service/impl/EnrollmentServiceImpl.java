package com.example.course_management_v2.service.impl;

import com.example.course_management_v2.enums.CourseStatus;
import com.example.course_management_v2.model.Course;
import com.example.course_management_v2.model.Enrollment;
import com.example.course_management_v2.repository.IEnrollmentRepository;
import com.example.course_management_v2.service.ICourseService;
import com.example.course_management_v2.service.IEnrollmentService;
import com.example.course_management_v2.service.IInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements IEnrollmentService {
    private final IEnrollmentRepository enrollmentRepository;
    private final ICourseService courseService;
    private final IInstructorService instructorService;

    @Autowired
    public EnrollmentServiceImpl(
            IEnrollmentRepository enrollmentRepository,
            ICourseService courseService,
            IInstructorService instructorService) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    @Override
    public List<Enrollment> getAllEnrollment() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found."));
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {

        Course course;

        try {
            course = courseService.getCourseById(enrollment.getCourseId());
        } catch (RuntimeException e) {
            throw new RuntimeException("Course of enrollment not found.");
        }

        if (course.getStatus() == CourseStatus.INACTIVE) {
            throw new RuntimeException("Course of enrollment is inactive.");
        }

        try {
            instructorService.getInstructorById(course.getInstructorId());
        } catch (RuntimeException e) {
            throw new RuntimeException("Instructor of enrollment's course not found.");
        }

        return enrollmentRepository.create(enrollment)
                .orElseThrow(() -> new RuntimeException("Enrollment cannot be created."));
    }

    @Override
    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {

//        Enrollment existingEnrollment = enrollmentRepository.findById(id);
//
//        if (existingEnrollment == null) {
//            return null;
//        }

        try {
            courseService.getCourseById(enrollment.getCourseId());
        } catch (RuntimeException e) {
            throw new RuntimeException("Course of enrollment not found.");
        }

        return enrollmentRepository.update(id, enrollment)
                .orElseThrow(() -> new RuntimeException("Enrollment not found."));
    }

    @Override
    public Enrollment deleteEnrollmentById(Long id) {

//        Enrollment existingEnrollment = enrollmentRepository.findById(id);
//
//        if (existingEnrollment == null) {
//            return null;
//        }

        return enrollmentRepository.deleteById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found."));
    }

}
