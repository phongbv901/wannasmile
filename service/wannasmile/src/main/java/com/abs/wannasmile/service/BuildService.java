package com.abs.wannasmile.service;

import com.abs.wannasmile.data.model.Build;
import com.abs.wannasmile.data.repository.BuildRepository;
import com.abs.wannasmile.data.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by phongbv on 5/22/17.
 */
@Service
public class BuildService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    BuildRepository buildRepository;

    @Autowired
    DeviceService deviceService;

   public String createBuild(Build build){
       if(build != null){
           build.setCreatedDate(new Date());
           build = buildRepository.save(build);
           deviceService.checkDevice(build.getOsType());
           return build.getBuildId();
       }
       return null;
   }

    public Build getBuild(String id){
        if(id != null){
            return buildRepository.findOne(id);
        }
        return null;
    }
    public List<Build> getAll(){
        return buildRepository.findAll();
    }
}
