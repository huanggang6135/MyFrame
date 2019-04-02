package org.hg.shiro.repository;

import org.hg.shiro.dto.User;
import org.hg.shiro.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author hg
 * @Date 2019/3/26 11:19
 * @Version 1.0
 **/
@Repository
public interface UserRepository extends BaseRepository<User, String> {
    /** 通过name查找用户
     * @param name
     * @return
     */
    User findByName(String name);
}
