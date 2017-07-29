package com.cdhorn.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Contact {

    @RequestMapping("/contact")
    public String contact(ModelMap model) {


        return "contact";
    }
}
