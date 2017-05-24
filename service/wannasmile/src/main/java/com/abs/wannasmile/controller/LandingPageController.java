package com.abs.wannasmile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class LandingPageController {


@RequestMapping({"/home"})
public String showHomePage(Map<String, Object> model) {
    return "/html/dashboard.html";
   }
}