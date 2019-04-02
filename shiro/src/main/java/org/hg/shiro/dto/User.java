package org.hg.shiro.dto;

import lombok.*;
import org.hg.shiro.dto.base.BaseDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author hg
 * @Date 2019/3/26 11:14
 * @Version 1.0
 **/
@Setter
@Getter
@Entity
@Table(name = "tb_shiro_user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseDTO {

    private static final long serialVersionUID = -8467126410988933720L;
    @Id
    @Column
    private String id;
    @Column(unique = true)
    private String name;
    @Column
    private String password;
}
