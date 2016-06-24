package com.epam.msfrolov.controller;


import com.epam.msfrolov.model.News;
import com.epam.msfrolov.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Spring MVC Front Controller
 */
@Controller
@RequestMapping("/")
public class NewsController {
    private static final Logger LOG = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    @Qualifier("newsService")
    private NewsService service;

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome(ModelMap ignoreModel) {
        LOG.debug("WELCOME!!!");
        return "page/view-welcome";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("newsList", service.getAll());
        return "page/view-list";
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String view(@RequestParam("id") Integer id, ModelMap model) {
        model.addAttribute("newsItem", service.findById(id));
        return "page/view-news";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String getEdit(@ModelAttribute("newsItem") News news, ModelMap model) {
        model.addAttribute("newsItem", news);
        return "page/view-edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String postEdit(@ModelAttribute("newsItem") News news, ModelMap model) {
        service.update(news);
        model.addAttribute("newsItem", news);
        return "page/view-edit";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String getAdd(ModelMap model) {
        model.put("newsItem", new News());
        return "page/view-add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("newsItem") News news, ModelMap model) {
        News savedNews = service.save(news);
        model.put("newsItem", savedNews);
        return "page/view-add";
    }


    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(ModelMap model) {
        LOG.debug("DELETE!!!");
        return "page/view-list";
    }
}
