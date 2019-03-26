package org.hg.shiro.dao;

import org.hg.shiro.dao.base.BaseDAO;
import org.hg.shiro.dto.User;
import org.springframework.stereotype.Repository;

/**
 * @Author hg
 * @Date 2019/3/26 11:19
 * @Version 1.0
 **/
@Repository
public interface UserDAO extends BaseDAO<User, String> {
}
