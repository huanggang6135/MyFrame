package org.hg.shiro.service;

import org.hg.shiro.dto.OperateLog;
import org.hg.shiro.repository.OperateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hg
 * @Date 2019/4/4 18:16
 * @Version 1.0
 **/
@Service
public class OperateLogService {
    @Autowired
    private OperateLogRepository repository;

    public OperateLog save(OperateLog operateLog){
        return repository.save(operateLog);
    }
}
