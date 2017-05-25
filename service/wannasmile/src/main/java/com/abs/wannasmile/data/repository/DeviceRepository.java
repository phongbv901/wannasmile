package com.abs.wannasmile.data.repository;

import com.abs.wannasmile.data.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by phongbv on 5/22/17.
 */
public interface DeviceRepository extends MongoRepository<Device,String>{

    List<Device> findDevicesByOsType(String osType);

    List<Device> findDevicesByOsTypeAndAccountUid(String osType, String accountUid);

    List<Device> findDevicesByAccountUidOrderByUpdateStatusDesc(String accountUid);
}
