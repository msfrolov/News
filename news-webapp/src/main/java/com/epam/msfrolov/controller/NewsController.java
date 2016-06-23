package com.epam.msfrolov.controller;


import com.epam.msfrolov.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Spring MVC Front Controller
 */
@Controller
@RequestMapping("/")
public class NewsController {


    @Autowired
    @Qualifier("newsService")
    NewsService service;

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String viewList(ModelMap model) {
        model.addAttribute("newsList", service.getAll());
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "page/view-welcome";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String viewAdd(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "page/view-add";
    }
}
