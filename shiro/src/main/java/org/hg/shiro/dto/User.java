package org.hg.shiro.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
@ToString
public class User extends BaseDTO {
    @Id
    @Column
    private String id;
    @Column
    private String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
