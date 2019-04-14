package org.hg.shiro.dto;

import lombok.*;
import org.hg.shiro.dto.base.BaseDTO;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author hg
 * @Date 2019/4/3 11:45
 * @Version 1.0
 **/
@Entity
@Table(name="tb_shiro_role")
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Proxy(lazy = false)
public class Role extends BaseDTO {
    private static final long serialVersionUID = -7408172985765088136L;
    @Id
    @Column(length = 32)
    @NonNull private String id;
    @Column(name="role_key", unique = true)
    @NonNull private String key;
    @Column
    @NonNull private String name;
    @Column
    private String note;
    @Transient
    private Set<String> sources;

    public Role(@NonNull String id, @NonNull String key, @NonNull String name, String note) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.note = note;
    }
}
