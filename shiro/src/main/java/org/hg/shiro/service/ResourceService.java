package org.hg.shiro.service;

import com.alibaba.druid.util.StringUtils;
import org.hg.shiro.dto.Resource;
import org.hg.shiro.repository.ResourceRepository;
import org.hg.shiro.util.Encrypts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
    public Page<Resource> find(Specification specification, Pageable pageable){
        return resourceRepository.findAll(specification, pageable);
    }
    public Page<Resource> find(Pageable pageable){
        return resourceRepository.findAll(pageable);
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

    public Page<Resource> find(int start, int length, String find) {
        Pageable pageable = PageRequest.of(start, length, Sort.Direction.DESC, "createTime");
        Page page = null;
        if(StringUtils.isEmpty(find)){
            page= resourceRepository.findAll(pageable);
        } else {
            page = resourceRepository.findAll(
                    (root, criteriaQuery, criteriaBuilder) ->
                            criteriaQuery.where(criteriaBuilder.like(root.get("name"), "%" + find + "%")).getRestriction()
                    , pageable);
        }
        return page;
    }
}
