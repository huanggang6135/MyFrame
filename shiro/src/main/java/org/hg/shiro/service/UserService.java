package org.hg.shiro.service;


import org.hg.shiro.dao.UserDAO;
import org.hg.shiro.dto.User;
import org.hg.shiro.util.Encript;
import org.hg.shiro.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hg
 * @Date 2019/3/26 11:18
 * @Version 1.0
 **/
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public Result addUser(String password, Result<Object> result) {
        User user = userDAO.save(new User(Encript.uuid(), Encript.md5(password)));
        return result;
    }
}
