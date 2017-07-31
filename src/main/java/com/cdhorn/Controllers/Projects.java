package com.cdhorn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Projects {

//    @Autowired
//    private ProjectRepositoryImpl repo;

    @RequestMapping("/projects")
    public String projects(Model model) {


        return "projects";
    }

}
