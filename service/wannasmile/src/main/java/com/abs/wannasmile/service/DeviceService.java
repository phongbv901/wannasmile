package com.abs.wannasmile.service;

import com.abs.wannasmile.data.model.Device;
import com.abs.wannasmile.data.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by phongbv on 5/22/17.
 */
@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public Device getDevice(String id){
        if(id != null && !id.isEmpty()){
            return deviceRepository.findOne(id);
        }
        return null;
    }

    public String createDevice(Device device){
        if(device != null){
            device.setDeviceId(UUID.randomUUID().toString());
            device = deviceRepository.save(device);
            return device.getDeviceId();
        }
        return null;
    }
}
