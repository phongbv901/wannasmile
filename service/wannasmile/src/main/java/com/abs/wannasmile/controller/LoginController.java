/**
 * Copyright (c) 2017 Absolute Software Corporation. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form or by any means,
 * electronic, mechanical or otherwise, is prohibited without the prior written
 * consent of the copyright owner.
 */
package com.abs.wannasmile.controller;

import com.abs.wannasmile.data.model.User;
import com.abs.wannasmile.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView showHomePage(Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        userService.removeSession(request);
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping(value = {"/login"})
    public ModelAndView login(@ModelAttribute("user") User user, HttpServletRequest request) {
        User loggedUser = userService.checkLogin(user.getUserName(), user.getPassword());
        if(loggedUser==null){
            ModelAndView modelAndView = new ModelAndView("redirect:/login");
            modelAndView.addObject("error", "message");
            return modelAndView;
        }else{
            userService.setSession(request, loggedUser  );
            if (loggedUser.getAdmin()){
                ModelAndView modelAndView = new ModelAndView("redirect:/home");
                return modelAndView;
            }else{
                ModelAndView modelAndView = new ModelAndView("redirect:/mydevice");
                return modelAndView;
            }
        }
    }

}
