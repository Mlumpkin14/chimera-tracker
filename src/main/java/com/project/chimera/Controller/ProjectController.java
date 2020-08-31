package com.project.chimera.Controller;

import com.project.chimera.Model.Issues;
import com.project.chimera.Model.Projects;
import com.project.chimera.Services.IssueService;
import com.project.chimera.Services.ProjectService;
import com.project.chimera.Model.Issues;
import com.project.chimera.Model.Projects;
import com.project.chimera.Repositories.ProjectsRepository;
import com.project.chimera.Services.IssueService;
import com.project.chimera.Services.ProjectService;
import com.project.chimera.Services.springdatajpa.IssueServiceImpl;
import com.project.chimera.Services.springdatajpa.ProjectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
public class ProjectController {

    private final ProjectServiceImpl projectService;
    private final IssueServiceImpl  issueService;

    public ProjectController(ProjectServiceImpl projectService, IssueServiceImpl issueService) {
        this.projectService = projectService;
        this.issueService = issueService;
    }

    @RequestMapping("projects")
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.findAll());

        return "showProjects";
    }


    @RequestMapping("projects/new")
    public String projectForm(Model model){
        model.addAttribute("projects", new Projects());
        return "newProject";
    }

    public String processProjects(Projects project, Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "newProject";
        }
        projectService.save(project);
        sessionStatus.setComplete();

        log.info("Project Submitted " + project);
        return "redirect:/";
    }
}
