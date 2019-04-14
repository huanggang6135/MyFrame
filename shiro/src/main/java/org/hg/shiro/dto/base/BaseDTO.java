package org.hg.shiro.dto.base;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author hg
 * @Date 2019/3/26 11:09
 * @Version 1.0
 **/
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDTO implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false)
    protected Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date updateTime;
}
