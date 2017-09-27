package com.cdhorn.Controllers;

import com.cdhorn.Interfaces.ProjectRepository;
import com.cdhorn.Models.Project;
import com.cdhorn.Models.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
                                @RequestParam("walkthrough") String walkthrough,
                                @RequestParam("viewable") String viewable) {

        Project newProject = new Project();
        newProject.setTitle(title);
        newProject.setImage(image);
        newProject.setTechnologies(technologies);
        newProject.setDescription(description);
        newProject.setCompleted(completed);
        newProject.setUrl(url);
        newProject.setCode(code);
        newProject.setWalkthrough(walkthrough);
        if (viewable.equals("True")) {
            newProject.setViewable(true);
        } else {
            newProject.setViewable(false);
        }
        projectRepo.save(newProject);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/deleteProject", method = RequestMethod.POST)
    public String deleteProject(@RequestParam("id") long id) {
        projectRepo.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/updateProject/{id}", method = RequestMethod.GET)
    public String updateProject(@PathVariable("id") long id,
                                Model model) {
            Project project = projectRepo.findOne(id);
            model.addAttribute("project", project);
            return "edit";
    }

    @RequestMapping(value = "/admin/updateProject/{id}", method = RequestMethod.POST)
    public String updateProject(@PathVariable("id") long id,
                                @RequestParam("title") String title,
                                @RequestParam("image") String image,
                                @RequestParam("technologies") String technologies,
                                @RequestParam("description") String description,
                                @RequestParam("completed") String completed,
                                @RequestParam("url") String url,
                                @RequestParam("code") String code,
                                @RequestParam("walkthrough") String walkthrough,
                                @RequestParam("viewable") String viewable,
                                Model model) {
        Project project = projectRepo.findOne(id);
        project.setTitle(title);
        project.setImage(image);
        project.setTechnologies(technologies);
        project.setDescription(description);
        project.setCompleted(completed);
        project.setUrl(url);
        project.setCode(code);
        project.setWalkthrough(walkthrough);
        if (viewable.equals("True")) {
            project.setViewable(true);
        } else {
            project.setViewable(false);
        }

        projectRepo.save(project);
        model.addAttribute(project);
        return "redirect:/admin";
    }

}



