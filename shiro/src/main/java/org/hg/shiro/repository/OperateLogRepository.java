package org.hg.shiro.repository;

import org.hg.shiro.dto.OperateLog;
import org.hg.shiro.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface OperateLogRepository extends BaseRepository<OperateLog, String> {
}
