package org.hg.shiro.repository;

import org.hg.shiro.dto.UserRole;
import org.hg.shiro.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository
public interface UserRoleRepository extends BaseRepository<UserRole, String> {
    /** 清空用户角色
     * @param userId
     */
    void deleteUserRoleByUserId(String userId);

    /** 根据用户id获取中间表
     * @param userId
     * @return
     */
    List<UserRole> findUserRolesByUserId(String userId);

    /** 通过角色ID删除
     * @param roleId
     */
    void deleteByRoleId(String roleId);
}
