package com.crud.service;

import com.crud.entity.Subject;
import com.crud.exception.SubjectNotFoundException;
import com.crud.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Subject saveSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public List<Subject> saveSubjects(List<Subject> subjects){
        return subjectRepository.saveAll(subjects);
    }

    public Subject getSubjectById(int id){
        return subjectRepository.findById(id).orElse(null);
    }

    public Page<Subject> getSubjectsByPagination(Pageable pageable){
        //we can also return the List<Subject>
        //List<Subject> subjects = subjectRepository.findAll(pageable).getContent();
        return subjectRepository.findAll(pageable);
    }

    public Subject updateSubject(Subject requestSubject, int id) throws Exception{
        return subjectRepository.findById(id).map((subject) -> {
            subject.setSub_name(requestSubject.getSub_name());
            subject.setMarks_obtained(requestSubject.getMarks_obtained());
            subject.setPassing_marks(requestSubject.getPassing_marks());
            subject.setTotal_marks(requestSubject.getTotal_marks());
            return subjectRepository.save(subject);
        }).orElseThrow(() -> new SubjectNotFoundException("Subject id " + id + " is not valid"));
    }
    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }
}
