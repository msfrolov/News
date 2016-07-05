package com.epam.msfrolov.controller;


import com.epam.msfrolov.dto.ArrayDTO;
import com.epam.msfrolov.dto.NewsDTO;
import com.epam.msfrolov.service.NewsService;
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

    private static final String PAGE_NEWS_LIST = "page/view-list";
    private static final String PAGE_NEWS_ADD = "page/view-add";
    private static final String PAGE_NEWS_EDIT = "page/view-edit";
    private static final String PAGE_SHOW_NEWS = "page/view-news";
    private static final String PAGE_NEWS_WELCOME = "page/view-welcome";

    @Autowired
    @Qualifier("newsService")
    private NewsService service;

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome(ModelMap ignoreModel) {
        return PAGE_NEWS_WELCOME;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("newsList", service.getAll());
        model.addAttribute("ids", new NewsDTO());
        return PAGE_NEWS_LIST;
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String view(@RequestParam(value = "id") Integer id, ModelMap model) {
        model.addAttribute("newsItem", service.findById(id));
        return PAGE_SHOW_NEWS;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id") Integer id, ModelMap model) {
        model.addAttribute("newsItem", service.findById(id));
        return PAGE_NEWS_EDIT;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String postEdit(@ModelAttribute(value = "newsItem") NewsDTO news, @RequestParam(value = "id") Integer id, ModelMap model) {
        news.setId(id);
        service.update(news);
        model.addAttribute("newsItem", news);
        model.addAttribute("message", "body.message.edit");
        return PAGE_SHOW_NEWS;
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String getAdd(ModelMap model) {
        model.put("newsItem", new NewsDTO());
        return PAGE_NEWS_ADD;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("newsItem") NewsDTO news, ModelMap model) {
        NewsDTO savedNews = service.save(news);
        model.put("newsItem", savedNews);
        model.addAttribute("message", "body.message.add");
        return PAGE_SHOW_NEWS;
    }


    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute("ids") ArrayDTO dto, ModelMap model) {
        service.remove(dto.getIds());
        model.addAttribute("newsList", service.getAll());
        model.addAttribute("ids", dto);
        //efgwergerg
        //efgwergerg
        //efgwergerg
        //efgwergerg
        //efgwergerg
        return PAGE_NEWS_LIST;
    }
}
