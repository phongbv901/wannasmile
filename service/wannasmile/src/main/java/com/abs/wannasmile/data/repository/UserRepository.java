package com.abs.wannasmile.data.repository;

import com.abs.wannasmile.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by phongbv on 5/25/17.
 */
public interface UserRepository extends MongoRepository<User,String> {

     User findUserByUserNameAndPassword(String userName, String password);

     Integer countByUserName(String userName);
}
