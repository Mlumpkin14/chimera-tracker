package com.project.chimera.bootstrap;

import com.project.chimera.Services.IssueService;
import com.project.chimera.Services.ProjectService;
import com.project.chimera.Model.Issues;
import com.project.chimera.Model.Priority;
import com.project.chimera.Model.Projects;
import com.project.chimera.Model.Status;
import com.project.chimera.Repositories.IssuesRepository;
import com.project.chimera.Repositories.ProjectsRepository;
import com.project.chimera.Services.IssueService;
import com.project.chimera.Services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class ProjectBootsrap implements CommandLineRunner {

    private final ProjectService projectService;
    private final IssueService issueService;

    public ProjectBootsrap(ProjectService projectService, IssueService issueService) {
        this.projectService = projectService;
        this.issueService = issueService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = projectService.findAll().size();

        if(count == 0){
            loadData();
        }

    }

    private void loadData(){
        Projects website = new Projects();
        website.setId(001);
        website.setCreatedAt(new Date());
        website.setProjectName("Netflix");
        website.setDescription("Subscription model movie streaming platform");




        projectService.save(website);



        System.out.println("Loaded Projects...");

        Issues dbm1 = new Issues();
        dbm1.setIssueName("MySql Connection");
        dbm1.setSummary("Website needs to be connected to mysql database");
        dbm1.setSolution("Connection through application properties");
        dbm1.setProblem("No database connection");
        dbm1.setStatus(Status.Todo);
        dbm1.setPriority(Priority.HIGH);
        dbm1.setProject(website);
        website.getIssues().add(dbm1);
        issueService.save(dbm1);

        System.out.println("Loaded Issues...");


        Projects hermes = new Projects();
        hermes.setId(002);
        hermes.setCreatedAt(new Date());
        hermes.setProjectName("Hermes");
        hermes.setDescription("Website used for open source learning");

        projectService.save(hermes);
    }
}
