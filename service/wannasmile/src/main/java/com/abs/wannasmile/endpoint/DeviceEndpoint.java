package com.abs.wannasmile.endpoint;

import com.abs.wannasmile.data.model.Device;
import com.abs.wannasmile.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/all/{userId}", method = RequestMethod.GET)
    public List<Device> getDevices(@PathVariable(name = "userId") String id){
        return deviceService.findByUser(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getDevice(@RequestBody Device device){
        return deviceService.createDevice(device);
    }

    @RequestMapping(value = "/os/{os}", method = RequestMethod.POST)
    public List<Device> getDeviceByOs(@PathVariable(name = "os") String os){
        return deviceService.findByOsType(os);
    }

    @RequestMapping(value = "/checkStatus/{os}", method = RequestMethod.GET)
    public Integer checkDevice(@PathVariable(name = "os") String os){
        return deviceService.checkDevice(os);
    }
}
