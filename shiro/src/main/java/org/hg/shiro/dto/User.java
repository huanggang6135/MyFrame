package org.hg.shiro.dto;

import lombok.*;
import org.hg.shiro.dto.base.BaseDTO;

import javax.persistence.*;
import java.util.Set;

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
@RequiredArgsConstructor()
@ToString
public class User extends BaseDTO {

    private static final long serialVersionUID = -8467126410988933720L;
    @Id
    @Column(length = 32)
    @NonNull private String id;
    @Column(unique = true)
    @NonNull private String name;
    @Column
    @NonNull private String password;
    @Column
    @NonNull private int salt;
    @Transient
    private Set<String> roles;
    @Transient
    private Set<String> sources;
}
