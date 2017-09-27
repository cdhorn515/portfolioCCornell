package com.cdhorn.Controllers;

import com.cdhorn.Interfaces.ProjectRepository;
import com.cdhorn.Models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Projects {

    @Autowired
    private ProjectRepository projectRepo;

    @RequestMapping("/projects")
    public String projects(Model model) {
        Iterable<Project> allProjects = projectRepo.findAllByViewableIsTrue();
        model.addAttribute("projects", allProjects);
        return "projects";
    }

}
