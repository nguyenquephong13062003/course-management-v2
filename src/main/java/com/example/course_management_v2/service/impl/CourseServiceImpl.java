package com.example.course_management_v2.service.impl;

import com.example.course_management_v2.model.Course;
// import com.example.course_management_v2.repository.ICourseRepository;
import com.example.course_management_v2.repository.jpa.CourseRepository;
import com.example.course_management_v2.service.ICourseService;
import com.example.course_management_v2.service.IInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    private final CourseRepository courseRepository;
    private final IInstructorService instructorService;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, IInstructorService instructorService) {
        this.courseRepository = courseRepository;
        this.instructorService = instructorService;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found."));
    }

    @Override
    public Course createCourse(Course course) {

        try {
            instructorService.getInstructorById(course.getInstructorId());
        } catch (RuntimeException e) {
            throw new RuntimeException("Instructor of course not found.");
        }

        course.setId(null);

        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {

//        Course existingCourse = courseRepository.findById(id);
//
//        if (existingCourse == null) {
//            return null;
//        }

        Course existingCourse = getCourseById(id);

        try {
            instructorService.getInstructorById(course.getInstructorId());
        } catch (RuntimeException e) {
            throw new RuntimeException("Instructor of course not found.");
        }

        course.setId(id);

        return courseRepository.save(course);
    }

    @Override
    public Course deleteCourseById(Long id) {

//        Course existingCourse = courseRepository.findById(id);
//
//        if (existingCourse == null) {
//            return null;
//        }

        Course existingCourse = getCourseById(id);

        courseRepository.deleteById(id);

        return existingCourse;
    }

}
