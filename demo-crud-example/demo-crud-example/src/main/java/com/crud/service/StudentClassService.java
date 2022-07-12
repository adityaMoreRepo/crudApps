package com.crud.service;

import com.crud.entity.StudentClass;
import com.crud.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentClassService {
    @Autowired
    StudentClassRepository studentClassRepository;
    public StudentClass getStudentClassById(int id){
        return studentClassRepository.findById(id).orElse(null);
    }
}
