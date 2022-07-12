package com.crud.repository;

import com.crud.entity.StudentClass;
import com.crud.entity.Subject;
import com.crud.service.StudentClassService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentClassRepositoryTest {
    @Autowired
    StudentClassRepository studentClassRepository;
    @Test
    public void saveStudentClass(){
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
        studentClassRepository.save(studentClass);
    }

}