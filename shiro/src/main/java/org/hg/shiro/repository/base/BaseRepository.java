package org.hg.shiro.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * @Author hg
 * @Date 2019/3/26 11:21
 * @Version 1.0
 **/
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    /** 通过id查找，不存在则返回null
     * @param id
     * @return
     */
    default T findOne(ID id){
        Optional<T> byId = findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }
}
