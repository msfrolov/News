package com.epam.msfrolov.controller;


import com.epam.msfrolov.dto.ArrayDTO;
import com.epam.msfrolov.dto.NewsDTO;
import com.epam.msfrolov.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
        model.addAttribute("ids", new ArrayDTO());
        return PAGE_NEWS_LIST;
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String view(@RequestParam(value = "id") Integer id, ModelMap model) {
        model.addAttribute("newsDTO", service.findById(id));
        return PAGE_SHOW_NEWS;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id") Integer id, ModelMap model) {
        model.addAttribute("newsDTO", service.findById(id));
        return PAGE_NEWS_EDIT;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String postEdit(@ModelAttribute(value = "newsDTO") @Valid NewsDTO newsDTO, final BindingResult result, @RequestParam(value = "id") Integer id, ModelMap model) {
        if (result.hasErrors()) {
            return PAGE_NEWS_EDIT;
        }
        newsDTO.setId(id);
        service.update(newsDTO);
        model.addAttribute("newsDTO", newsDTO);
        model.addAttribute("message", "body.message.edit");
        return PAGE_SHOW_NEWS;
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String getAdd(ModelMap model) {
        model.put("newsDTO", new NewsDTO());
        return PAGE_NEWS_ADD;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("newsDTO") @Valid NewsDTO newsDTO, final BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return PAGE_NEWS_ADD;
        }
        NewsDTO savedNews = service.save(newsDTO);
        model.put("newsDTO", savedNews);
        model.addAttribute("message", "body.message.add");
        return PAGE_SHOW_NEWS;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute("ids") ArrayDTO dto, ModelMap model) {
        service.remove(dto.getIds());
        model.addAttribute("newsList", service.getAll());
        model.addAttribute("ids", dto);
        return PAGE_NEWS_LIST;
    }
}
