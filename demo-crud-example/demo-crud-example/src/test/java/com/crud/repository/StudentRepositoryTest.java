package com.crud.repository;

import com.crud.entity.Address;
import com.crud.entity.Student;
import com.crud.entity.StudentClass;
import com.crud.entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Address address = Address.builder()
                .city("Pune")
                .flat_no(201)
                .road("MG Road")
                .mobile_no("9028594021")
                .state("Maharashtra")
                .pin("412041")
                .build();

        Subject math = Subject.builder()
                .sub_name("Math")
                .marks_obtained(75)
                .passing_marks(40)
                .total_marks(100)
                .build();

        Subject english = Subject.builder()
                .sub_name("English")
                .marks_obtained(65)
                .passing_marks(40)
                .total_marks(100)
                .build();

        Subject physics = Subject.builder()
                .sub_name("Physics")
                .marks_obtained(75)
                .passing_marks(40)
                .total_marks(100)
                .build();

        Subject chemistry = Subject.builder()
                .sub_name("Chemistry")
                .marks_obtained(85)
                .passing_marks(40)
                .total_marks(100)
                .build();

        Subject biology = Subject.builder()
                .sub_name("Biology")
                .marks_obtained(60)
                .passing_marks(40)
                .total_marks(100)
                .build();

        Subject hindi = Subject.builder()
                .sub_name("Hindi")
                .marks_obtained(68)
                .passing_marks(40)
                .total_marks(100)
                .build();

        StudentClass studentClass = StudentClass.builder()
                .standard(10)
                .subjects(Arrays.asList(math, english, biology, physics, chemistry, hindi))
                .build();

        Student student = Student.builder()
                .firstName("Vikas")
                .lastName("Sharma")
                .gender("Male")
                .address(address)
                .studentClass(studentClass)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> students = studentRepository.findAll();
        for(Student value: students){
            System.out.println(value);
        }
    }
}