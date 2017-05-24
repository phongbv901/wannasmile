package com.abs.wannasmile.controller;

import com.abs.wannasmile.data.model.Build;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abs.wannasmile.service.BuildService;

import java.util.Map;

@Controller
public class LandingPageController {

    @Autowired
    private BuildService buildService;

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView showHomePage(Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("buildList", buildService.getAll());
        modelAndView.addObject("build", new Build());
        return modelAndView;
    }

    @PostMapping(value = {"/home"})
    public String post(@ModelAttribute("build") Build build) {
        buildService.createBuild(build);
        return "redirect:/home";
    }
}