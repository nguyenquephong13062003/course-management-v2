package com.example.course_management_v2.service.impl;

import com.example.course_management_v2.dto.request.InstructorCreateRequest;
import com.example.course_management_v2.model.Instructor;
// import com.example.course_management_v2.repository.IInstructorRepository;
import com.example.course_management_v2.repository.jpa.InstructorRepository;
import com.example.course_management_v2.service.IInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements IInstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found."));
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {

        instructor.setId(null);

        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor createInstructor(InstructorCreateRequest request){

        Instructor instructor =
                new Instructor(
                        request.getName(),
                        request.getEmail());

        return repository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {

//        Instructor existingInstructor = instructorRepository.findById(id);
//
//        if (existingInstructor == null) {
//            return null;
//        }

        Instructor existingInstructor = getInstructorById(id);

        instructor.setId(id);

        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor deleteInstructorById(Long id) {

//        Instructor existingInstructor = instructorRepository.findById(id);
//
//        if (existingInstructor == null) {
//            return null;
//        }

        Instructor existingInstructor = getInstructorById(id);

        instructorRepository.deleteById(id);

        return existingInstructor;
    }

}
