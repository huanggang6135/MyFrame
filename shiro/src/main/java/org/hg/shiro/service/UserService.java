package org.hg.shiro.service;


import lombok.NonNull;
import org.hg.shiro.dto.Role;
import org.hg.shiro.dto.User;
import org.hg.shiro.dto.UserRole;
import org.hg.shiro.repository.RoleRepository;
import org.hg.shiro.repository.UserRepository;
import org.hg.shiro.repository.UserRoleRepository;
import org.hg.shiro.util.Encrypts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author hg
 * @Date 2019/3/26 11:18
 * @Version 1.0
 **/
@Service
public class UserService {
    @Autowired
    private UserRepository userDAO;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
//    @CachePut(value="user", key="#p0+'-name'")
    public User addUser(@NonNull String name, @NonNull String password) {
        int salt = Encrypts.randInt();
        return userDAO.save(new User(Encrypts.uuid(), name, Encrypts.passwordMd5(password, salt), salt));
    }
//    @Cacheable(value="user", key="#id+'-id'")
    public User findUserById(@NonNull String id) {
        return userDAO.findOne(id);
    }
//    @Cacheable(value="user", key="#p0+'-name'")
    public User findByName(@NonNull String name){
        return userDAO.findByName(name);
    }
//    @Caching(evict={
//            @CacheEvict(value="user", key="#user.name+'-name'"),
//            @CacheEvict(value="user", key="#user.id+'-id'")
//    })
    public void deleteUser(@NonNull User user){
        userDAO.delete(user);
    }

    public Set<String> findRolesByUserName(String username) {
        User byName = this.findByName(username);
        if(byName == null){
            return null;
        }
        List<UserRole> userRoles = userRoleRepository.findUserRolesByUserId(byName.getId());
        Set<String> roles = new HashSet<>(16);
        userRoles.forEach(userRole -> {
            Role role = roleRepository.findOne(userRole.getRoleId());
            if(role != null){
                roles.add(role.getName());
            }
        });
        return roles;
    }

    public Set<String> findPermissionsByUserName(String username) {
        return null;
    }
}
