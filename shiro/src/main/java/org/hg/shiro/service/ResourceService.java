package org.hg.shiro.service;

import org.hg.shiro.dto.Resource;
import org.hg.shiro.repository.ResourceRepository;
import org.hg.shiro.util.Encrypts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hg
 * @Date 2019/4/3 14:03
 * @Version 1.0
 **/
@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public Resource findById(String id) {
        return resourceRepository.findOne(id);
    }

    public Resource findByKey(String key) {
        return resourceRepository.findByKey(key);
    }

    public Resource add(String key, String name, String note) {
        return resourceRepository.save(new Resource(Encrypts.uuid(), key, name, note));
    }
    public void delete(String id){
        resourceRepository.deleteById(id);
    }
}
