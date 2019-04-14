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
 * @Date 2019/4/4 16:52
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_log_operate")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class OperateLog extends BaseDTO {
    @Id
    @Column(length = 32)
    private String id;
    @Column
    private String ip;
    @Column
    private String operator;
    @Column
    private String operateType;
    @Column
    private String url;
    @Column
    private String httpMethod;
    @Column
    private String args;
    @Column
    private int resultCode;
    @Column
    private String resultMessage;
    @Column
    private String exception;
}
