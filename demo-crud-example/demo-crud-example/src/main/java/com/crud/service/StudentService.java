package com.crud.service;

import com.crud.entity.Student;
import com.crud.exception.StudentNotFoundException;
import com.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student, int id){
        Student student1 = new Student();
        try{
            student1 = studentRepository.findById(id)
                    .orElseThrow(() -> new StudentNotFoundException("The Student id " + id + " not found"));
        }
        catch (StudentNotFoundException e){
            e.printStackTrace();
        }

        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setGender(student.getGender());
        student1.setStudentClass(student.getStudentClass());
        student1.setAddress(student.getAddress());
        return  this.studentRepository.save(student1);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(int id){
            return studentRepository.findById(id)
                    .orElse(null);
    }

    public ResponseEntity<Student> removeStudent(int id){
        Student student = new Student();
        try{
            student = studentRepository.findById(id)
                    .orElseThrow(() -> new StudentNotFoundException("The Student id " + id +" not found"));
        }
        catch (StudentNotFoundException e){
            e.printStackTrace();
        }
        this.studentRepository.delete(student);
        return ResponseEntity.ok().build();
    }
}
