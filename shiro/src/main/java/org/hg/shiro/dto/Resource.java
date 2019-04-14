package org.hg.shiro.dto;

import lombok.*;
import org.hg.shiro.dto.base.BaseDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author hg
 * @Date 2019/4/3 11:40
 * @Version 1.0
 **/
@Entity
@Table(name="tb_shiro_resource")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Resource extends BaseDTO {
    private static final long serialVersionUID = 2249859189879982407L;
    @Id
    @Column(length = 32)
    private String id;
    @Column(name = "resource_key" ,unique = true)
    private String key;
    @Column
    private String name;
    @Column
    private String note;
}
