package com.example.course_management_v2.service;

import com.example.course_management_v2.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getAllCourse();

    Course getCourseById(Long id);

    Course createCourse (Course course);

    Course updateCourse (Long id, Course course);

    Course deleteCourseById(Long id);
}
