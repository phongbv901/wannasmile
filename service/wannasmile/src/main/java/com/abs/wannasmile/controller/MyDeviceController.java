package com.abs.wannasmile.controller;

import com.abs.wannasmile.data.model.Build;
import com.abs.wannasmile.service.BuildService;
import com.abs.wannasmile.service.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MyDeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = {"/mydevice"}, method = RequestMethod.GET)
    public ModelAndView showHomePage(Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("mydevice");
        modelAndView.addObject("deviceList", deviceService.getAll());
        return modelAndView;
    }

}