package org.hg.shiro.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author hg
 * @Date 2019/3/26 11:21
 * @Version 1.0
 **/
@NoRepositoryBean
public interface BaseDAO<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
