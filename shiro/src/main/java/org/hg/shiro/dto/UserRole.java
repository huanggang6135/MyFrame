package org.hg.shiro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hg.shiro.dto.base.BaseDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author hg
 * @Date 2019/4/3 13:48
 * @Version 1.0
 **/
@Entity
@Table(name="tb_shiro_user_role")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends BaseDTO {
    @Id
    @Column(length = 32)
    private String id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "role_id")
    private String roleId;
}
