package org.hg.shiro.repository;

import org.hg.shiro.dto.RoleResource;
import org.hg.shiro.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author hg
 * @Date 2019/4/3 14:13
 * @Version 1.0
 **/
@Repository
public interface RoleResourceRepository extends BaseRepository<RoleResource, String> {
    /** 删除角色
     * @param roleId
     */
    void deleteByRoleId(String roleId);
}
