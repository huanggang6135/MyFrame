package org.hg.shiro.service;


import lombok.NonNull;
import org.hg.shiro.dto.User;
import org.hg.shiro.repository.UserRepository;
import org.hg.shiro.util.Encript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author hg
 * @Date 2019/3/26 11:18
 * @Version 1.0
 **/
@Service
public class UserService {
    @Autowired
    private UserRepository userDAO;
    @CachePut(value="user", key="#p0+'-name'")
    public User addUser(@NonNull String name, @NonNull String password) {
        return userDAO.save(new User(Encript.uuid(), name, Encript.md5(password)));
    }
    @Cacheable(value="user", key="#id+'-id'")
    public User findUserById(@NonNull String id) {
        Optional<User> byId = userDAO.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }
    @Cacheable(value="user", key="#p0+'-name'")
    public User findByName(@NonNull String name){
        return userDAO.findByName(name);
    }
    @Caching(evict={
            @CacheEvict(value="user", key="#user.name+'-name'"),
            @CacheEvict(value="user", key="#user.id+'-id'")
    })
    public void deleteUser(@NonNull User user){
        userDAO.delete(user);
    }
}
