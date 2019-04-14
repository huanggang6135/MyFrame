package org.hg.shiro.repository;

import org.hg.shiro.dto.Role;
import org.hg.shiro.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author hg
 * @Date 2019/4/3 14:04
 * @Version 1.0
 **/
@Repository
public interface RoleRepository extends BaseRepository<Role, String> {
    /** 通过key查找
     * @param key
     * @return
     */
    Role findByKey(String key);
}
