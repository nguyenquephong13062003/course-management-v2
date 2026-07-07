package com.example.course_management_v2.model;

import com.example.course_management_v2.enums.CourseStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course implements Identifiable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseStatus status;

    @Column(name = "instructor_id")
    private Long instructorId;

    public Course() {
    }

    public Course(Long id, String title, CourseStatus status, Long instructorId) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.instructorId = instructorId;
    }

    public Course(String title, CourseStatus status, Long instructorId) {
        this.title = title;
        this.status = status;
        this.instructorId = instructorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", instructorId=" + instructorId +
                '}';
    }

}
