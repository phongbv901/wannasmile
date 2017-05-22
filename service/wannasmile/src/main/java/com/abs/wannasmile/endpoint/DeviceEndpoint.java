package com.abs.wannasmile.endpoint;

import com.abs.wannasmile.data.model.Device;
import com.abs.wannasmile.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by phongbv on 5/22/17.
 */
@RestController
@RequestMapping("/device")
public class DeviceEndpoint {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Device getDevice(@PathVariable(name = "id") String id){
        return deviceService.getDevice(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getDevice(@RequestBody Device device){
        return deviceService.createDevice(device);
    }
}
