package com.crud.repository;

import com.crud.entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class SubjectRepositoryTest {
    @Autowired
    SubjectRepository subjectRepository;
    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords =
                PageRequest.of(1, 2);

        List<Subject> subjects = subjectRepository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println("Subjects: " + subjects );

    }
    @Test
    public void saveSubject(){
        Subject subject = Subject.builder()
                .sub_name("someSubject")
                .marks_obtained(60)
                .passing_marks(40)
                .total_marks(100)
                .build();
        subjectRepository.save(subject);
    }

    @Test
    public void findAllSorting(){
        Pageable sortBySubName =
                PageRequest.of(
                        0,
                        2
//                        Sort.by("sub_name")
                );// by default ascending
        Pageable sortBySubNameDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("sub_name").descending()// here sub_name is not valid
                        // it should have been camel case. same for subject_id
                );
        Pageable sortBySubIdAndSubName =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("subject_id")
                                .and(Sort.by("sub_name").descending())
                );
        List<Subject> subjects = subjectRepository.findAll(sortBySubIdAndSubName).getContent();
        System.out.println(subjects);
    }

}