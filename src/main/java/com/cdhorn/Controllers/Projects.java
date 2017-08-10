package com.cdhorn.Controllers;

import com.cdhorn.Models.Project;
import com.cdhorn.Repositories.ProjectRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Projects {

    @Autowired
    private ProjectRepositoryImpl repo;

    @RequestMapping("/projects")
    public String projects(Model model) {
        List<Project> allProjects = repo.findAll();
        model.addAttribute("projects", allProjects);
        return "projects";
    }

}
