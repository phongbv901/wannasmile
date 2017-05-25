package com.abs.wannasmile.endpoint;

import com.abs.wannasmile.data.model.Build;
import com.abs.wannasmile.data.model.Device;
import com.abs.wannasmile.data.model.User;
import com.abs.wannasmile.service.BuildService;
import com.abs.wannasmile.service.DeviceService;
import com.abs.wannasmile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by phongbv on 5/22/17.
 */
@RestController
@RequestMapping("/build2")
public class BuildEndpoint {

    @Autowired
    BuildService buildService;

    @Autowired
    UserService userService;



    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getDevice(@RequestBody Build build){
        return buildService.createBuild(build);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Build getDevice(@PathVariable(name = "id") String id){
        return buildService.getBuild(id);
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String createUser(@RequestBody User user){
         userService.createUser(user);
        return "ok";
    }

}
