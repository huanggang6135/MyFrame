package org.hg.shiro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hg.shiro.dto.base.BaseDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author hg
 * @Date 2019/4/3 13:54
 * @Version 1.0
 **/
@Entity
@Table(name="tb_shiro_role_resource")
@Setter
@Getter
@AllArgsConstructor
public class RoleResource extends BaseDTO {
    @Id
    @Column(length = 32)
    private String id;
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "resource_id")
    private String resourceId;
}
