package com.cdhorn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Projects {

    @RequestMapping("/projects")
    public String home(ModelMap model) {


        return "projects";
    }
}
