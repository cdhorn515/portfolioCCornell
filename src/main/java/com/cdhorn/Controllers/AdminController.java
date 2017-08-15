package com.cdhorn.Controllers;

import com.cdhorn.Interfaces.ProjectRepository;
import com.cdhorn.Models.Project;
import com.cdhorn.Models.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class AdminController {

    @Autowired
    private ProjectRepository projectRepo;


        @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {
        model.addAttribute("user", new User());
        try {
            Object message = request.getSession().getAttribute("error");
            model.addAttribute("error", message);
        } catch (Exception ex) {}
        return "login";
    }

    @RequestMapping("/admin")
    public String index(Model model, Principal principal) {
        try {
            String username = principal.getName();
            model.addAttribute("username", username);
        } catch (Exception ex) {
            return "redirect:/login";
        }
        Iterable<Project> allProjects = projectRepo.findAll();
        model.addAttribute("projects", allProjects);
        return "admin";
    }

    @RequestMapping(value = "/admin/createProject", method = RequestMethod.POST)
    public String createProject(@RequestParam("title") String title,
                                @RequestParam("image") String image,
                                @RequestParam("technologies") String technologies,
                                @RequestParam("description") String description,
                                @RequestParam("completed") String completed,
                                @RequestParam("url") String url,
                                @RequestParam("code") String code,
                                @RequestParam("walkthrough") String walkthrough) {

        Project newProject = new Project();
        newProject.setTitle(title);
        newProject.setImage(image);
        newProject.setTechnologies(technologies);
        newProject.setDescription(description);
        newProject.setCompleted(completed);
        newProject.setUrl(url);
        newProject.setCode(code);
        newProject.setWalkthrough(walkthrough);
        projectRepo.save(newProject);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/deleteProject", method = RequestMethod.POST)
    public String deleteProject(@RequestParam("id") long id) {
        projectRepo.delete(id);
        return "redirect:/admin";
    }

}



