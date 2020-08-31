package com.project.chimera.Services.springdatajpa;

import com.project.chimera.Model.Issues;
import com.project.chimera.Repositories.IssuesRepository;
import com.project.chimera.Services.IssueService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssuesRepository issuesRepository;

    public IssueServiceImpl(IssuesRepository issuesRepository) {
        this.issuesRepository = issuesRepository;
    }

    public List<Issues> getIssues(){
        List<Issues> issues = new ArrayList<>();
        issuesRepository.findAll().forEach(issues::add);

        return issues;
    }

    @Override
    public List<Issues> findAll() {

        List<Issues> issues = new ArrayList<>();

        issuesRepository.findAll().forEach(issues::add);

        return issues ;
    }

    @Override
    public Issues findById(Long aLong) {
        return issuesRepository.findById(aLong).orElse(null);
    }

    @Override
    public Issues save(Issues object) {

        System.out.println("Issue Saved");

        return issuesRepository.save(object);
    }

    @Override
    public void delete(Issues object) {
        issuesRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        issuesRepository.deleteById(aLong);
    }
}
