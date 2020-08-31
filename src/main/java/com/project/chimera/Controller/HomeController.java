package com.project.chimera.Controller;

import com.project.chimera.Services.springdatajpa.IssueServiceImpl;
import com.project.chimera.Services.springdatajpa.ProjectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    private final ProjectServiceImpl projectServiceImpl;
    private final IssueServiceImpl issueServiceImpl;

    public HomeController(ProjectServiceImpl projectServiceImpl, IssueServiceImpl issueServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
        this.issueServiceImpl = issueServiceImpl;
    }

   @RequestMapping({" ","/","/welcome"})
    public String welcome(Model model) {

        model.addAttribute("projects", projectServiceImpl.getProjects());
        model.addAttribute("issues", issueServiceImpl.getIssues());

        return "welcome";
    }



}
