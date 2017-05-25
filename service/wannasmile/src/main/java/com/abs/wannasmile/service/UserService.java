package com.abs.wannasmile.service;

import com.abs.wannasmile.data.model.User;
import com.abs.wannasmile.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by phongbv on 5/25/17.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User checkLogin(String userName, String password) {
        if (userName != null && password != null) {
            return userRepository.findUserByUserNameAndPassword(userName, password);
        }
        return null;
    }

    public User getUserById(String accountUid) {
        if (accountUid != null) {
            return userRepository.findOne(accountUid);
        }
        return null;
    }

    public User checkSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            Object tmp = session.getAttribute("user");
            if (tmp != null) {
                return (User) tmp;
            }
        }
        return null;
    }

    public void setSession(HttpServletRequest request, User user) {
        if (request != null && user != null) {
            user.setPassword(null);
            request.setAttribute("user", user);
        }
    }

    public void removeSession(HttpServletRequest request) {
        if (request != null) {
            request.removeAttribute("user");
        }
    }

    public void setUserNoti(Set<String> accountUids) {
        if (accountUids != null) {
            for (String accountUid : accountUids) {
                if (accountUid != null) {
                    User user = userRepository.findOne(accountUid);
                    user.setHaveNoti(true);
                    userRepository.save(user);
                }
            }
        }

    }
    public void removeUserNoti(Set<String> accountUids) {
        if (accountUids != null) {
            for (String accountUid : accountUids) {
                if (accountUid != null) {
                    User user = userRepository.findOne(accountUid);
                    user.setHaveNoti(false);
                    userRepository.save(user);
                }
            }
        }

    }
}
