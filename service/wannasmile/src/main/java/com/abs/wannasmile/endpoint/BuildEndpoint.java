package com.abs.wannasmile.endpoint;

import com.abs.wannasmile.data.model.Build;
import com.abs.wannasmile.data.model.Device;
import com.abs.wannasmile.service.BuildService;
import com.abs.wannasmile.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by phongbv on 5/22/17.
 */
@RestController
@RequestMapping("/build")
public class BuildEndpoint {

    @Autowired
    BuildService buildService;



    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getDevice(@RequestBody Build build){
        return buildService.createBuild(build);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Build getDevice(@PathVariable(name = "id") String id){
        return buildService.getBuild(id);
    }

}
