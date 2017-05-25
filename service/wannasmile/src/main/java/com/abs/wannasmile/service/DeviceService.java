package com.abs.wannasmile.service;

import com.abs.wannasmile.data.model.Build;
import com.abs.wannasmile.data.model.Device;
import com.abs.wannasmile.data.repository.BuildRepository;
import com.abs.wannasmile.data.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by phongbv on 5/22/17.
 */
@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    BuildRepository buildRepository;

    @Autowired
    UserService userService;

    public Device getDevice(String id){
        if(id != null){
            return deviceRepository.findOne(id);
        }
        return null;
    }

    public String createDevice(Device device){
        if(device != null){
            device.setAccountUid("2CH83ZYU123SAF");
            device.setEsn("2CH83ZYU123SAF");
            device.setOsBuild("14393.1198");
            device.setOsType("Windows 10");
            device.setLastChecked(new Date());
            device.setUpdateStatus(1);
            device = deviceRepository.save(device);
            return device.getDeviceId();
        }
        return null;
    }

    public List<Device> findByOsType(String osType){
        return deviceRepository.findDevicesByOsType(osType);
    }

    public List<Device> findByUser(String userId){
        return deviceRepository.findDevicesByAccountUid(userId);
    }

    public Integer checkDevice(String osTpye){
        Build build = buildRepository.findBuildByOsTypeOrderByCreatedDate(osTpye);
        Integer count = 0;
        String refBuid = build.getBuildId();
        String osBuild = build.getOsBuild();
        Integer updateStatus = build.getUrgent() ? 2 : 1;
        Set<String> userIds = new HashSet<>();
        if(build != null){
            List<Device> devices = deviceRepository.findDevicesByOsType(build.getOsType());
            if(devices != null && !devices.isEmpty()){
                for(Device device : devices){
                    device.setLastChecked(new Date());
                    if(device.isOutofDate(osBuild)){
                        device.setRefBuild(refBuid);
                        device.setUpdateStatus(updateStatus);
                        count ++;
                        userIds.add(device.getAccountUid());
                    } else {
                        device.setUpdateStatus(0);
                        device.setRefBuild(null);
                    }
                    deviceRepository.save(device);
                }
            }
        }
        if(userIds.size() > 0){
            userService.setUserNoti(userIds);
        }
        return count;
    }

    public List<Device> getAll(){
        return deviceRepository.findAll();
    }
}
