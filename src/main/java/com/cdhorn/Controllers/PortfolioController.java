package com.cdhorn.Controllers;

import com.cdhorn.Models.Project;
import com.cdhorn.Repositories.ProjectRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PortfolioController {

    @Autowired
    private ProjectRepositoryImpl repo;

    @RequestMapping("/admin")
    public String index(Model model) {
        List<Project> allProjects = repo.findAll();
        model.addAttribute("projects", allProjects);
        return "admin";
    }

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public String createProject(@RequestParam("title") String title,
                                @RequestParam("image") String image,
                                @RequestParam("technologies") String technologies,
                                @RequestParam("description") String description,
                                @RequestParam("completed") String completed) {

        repo.add(title, image, technologies, description, completed);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
    public String deleteProject(@RequestParam("id") long id) {
        repo.delete(id);
        return "redirect:/admin";
    }

}

    //    @RequestMapping("/admin")
//    public String createProject(Model model) {
//        Project one = new Project(1, "/img/mystery_word.png", "Mystery Word", "Node", "hangman style game", "summer " +
//                "2017");
//        Project two = new Project(2, "/img/gabble.png", "Gabble", "Node, MongoDB", "twitter style web app", "summer " +
//                "2017");
//        ArrayList<Project> projects = new ArrayList<>();
//        projects.add(one);
//        projects.add(two);
//        model.addAttribute("projects", projects);
//        return "admin";
//    }
//
//    @RequestMapping(value="/admin", method = RequestMethod.POST)
//    public String createProject(@RequestParam("title") String title,
//                                @RequestParam("image") String image,
//                                @RequestParam("technologies") String technologies,
//                                @RequestParam("description") String description,
//                                @RequestParam("completed") String completed) {
//
//        repo.add(title, image, technologies, description, completed);
//        return "redirect:/admin";
//    }


