package com.abs.wannasmile.data.repository;

import com.abs.wannasmile.data.model.Build;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by phongbv on 5/23/17.
 */
public interface BuildRepository extends MongoRepository<Build,String> {

    Build findBuildByOsTypeOrderByReleasedDate(String osType);
}
