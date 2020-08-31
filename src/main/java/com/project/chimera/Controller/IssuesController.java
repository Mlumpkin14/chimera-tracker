package com.project.chimera.Controller;

import com.project.chimera.Services.IssueService;
import com.project.chimera.Services.springdatajpa.IssueServiceImpl;
import com.project.chimera.Services.springdatajpa.ProjectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IssuesController {

    private final ProjectServiceImpl projectService;
    private final IssueServiceImpl issueService;

    public IssuesController(ProjectServiceImpl projectService, IssueServiceImpl issueService) {
        this.projectService = projectService;
        this.issueService = issueService;
    }

    @RequestMapping("issues")
    public String listIssues(Model model){
        model.addAttribute("issues", issueService.findAll());

        return "showIssues";
    }
}
