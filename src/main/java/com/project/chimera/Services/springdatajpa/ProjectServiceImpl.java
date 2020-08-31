package com.project.chimera.Services.springdatajpa;

import com.project.chimera.Model.Projects;
import com.project.chimera.Repositories.IssuesRepository;
import com.project.chimera.Repositories.ProjectsRepository;
import com.project.chimera.Services.ProjectService;
import com.project.chimera.Model.Projects;
import com.project.chimera.Repositories.IssuesRepository;
import com.project.chimera.Repositories.ProjectsRepository;
import com.project.chimera.Services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectsRepository projectsRepository;
    private final IssuesRepository issuesRepository;

    public ProjectServiceImpl(ProjectsRepository projectsRepository, IssuesRepository issuesRepository) {
        this.projectsRepository = projectsRepository;
        this.issuesRepository = issuesRepository;
    }

    @Override
    public Projects findByProjectName(String projectName) {
        return projectsRepository.findByProjectName(projectName);
    }

    public List<Projects> getProjects(){
        List<Projects> projects = new ArrayList<>();
        projectsRepository.findAll().iterator().forEachRemaining(projects::add);

        return projects;
    }

    @Override
    public List<Projects> findAll() {

        List<Projects> projects = new ArrayList<>();

        projectsRepository.findAll().forEach(projects::add);

        return projects;

    }

    @Override
    public Projects findById(Long aLong) {
        return projectsRepository.findById(aLong).orElse(null);
    }

    @Override
    public Projects save(Projects object) {
        System.out.println("Project Saved");

        return projectsRepository.save(object);
    }

    @Override
    public void delete(Projects object) {
        projectsRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        projectsRepository.deleteById(aLong);
    }
}
