package com.crud.controller;

import com.crud.entity.Subject;
import com.crud.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService service;

    @PostMapping("/addSubject")
    public Subject addSubject(@RequestBody Subject subject){
        return service.saveSubject(subject);
    }

//    @GetMapping("/subjects")
//    public List<Subject> findAllSubjects(){
//        return service.getSubjects();
//    }

    @GetMapping("/subjects")
    public Page<Subject> findAllSubjects(Pageable pageable){
        return service.getSubjectsByPagination(pageable);
    }

    @PutMapping("/subject/{id}")
    public Subject updateSubject(@RequestBody Subject subject, @PathVariable int id) throws Exception {
        return service.updateSubject(subject, id);
    }

    @GetMapping("/subject/{id}")
    public Subject findProductById(@PathVariable int id){
        return service.getSubjectById(id);
    }
}
