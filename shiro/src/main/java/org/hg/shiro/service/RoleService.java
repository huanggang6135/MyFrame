package org.hg.shiro.service;

import org.hg.shiro.dto.Role;
import org.hg.shiro.dto.UserRole;
import org.hg.shiro.repository.RoleRepository;
import org.hg.shiro.repository.RoleResourceRepository;
import org.hg.shiro.repository.UserRoleRepository;
import org.hg.shiro.util.Encrypts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

/**
 * @Author hg
 * @Date 2019/4/3 14:08
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleResourceRepository roleResourceRepository;

    public Role add(String key, String name, String note) {
        return roleRepository.save(new Role(Encrypts.uuid(), key, name, note));
    }
    public Role findByKey(String key){
        return roleRepository.findByKey(key);
    }

    public boolean grantRole(String userId, String[] roleIds) {
        userRoleRepository.deleteUserRoleByUserId(userId);
        Stream.of(roleIds).filter(roleId->roleRepository.findById(roleId).isPresent()).forEach(
                roleId->userRoleRepository.save(new UserRole(Encrypts.uuid(), userId, roleId))
        );
        return true;
    }

    public void deleteById(String roleId) {
        roleResourceRepository.deleteByRoleId(roleId);
        userRoleRepository.deleteByRoleId(roleId);
        roleRepository.deleteById(roleId);
    }

    public Role findById(String roleId) {
        return roleRepository.findOne(roleId);
    }
}
