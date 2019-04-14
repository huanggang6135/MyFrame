package org.hg.shiro.repository;

import org.hg.shiro.dto.Resource;
import org.hg.shiro.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface ResourceRepository extends BaseRepository<Resource, String> {
    /** 通过key查找
     * @param key
     * @return
     */
    Resource findByKey(String key);
}
