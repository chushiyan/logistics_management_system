package com.chushiyan.bos.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 客户联系人 实体类
 */

@Data
@Entity
@EqualsAndHashCode(exclude = "customer")
@ToString(exclude = "customer")
public class Linkman implements Serializable {

    @Id
    @Column(name = "linkman_id")
    private String id;

    @Column(name = "linkman_name")
    private String name;

    @Column(name = "linkman_gender")
    private Integer gender;  // 0: female    1: male

    @Column(name = "linkman_phone")
    private String phone;

    @Column(name = "linkman_mobile")
    private String mobile;

    @Column(name = "linkman_email")
    private String email;

    @Column(name = "linkman_position")
    private String position;

    @Column(name = "linkman_memo")
    private String memo;

    @Column(name = "linkman_status")
    private Integer status;

    @JsonIgnoreProperties(value = {"linkmen"})
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;


}
