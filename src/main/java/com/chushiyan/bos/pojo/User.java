package com.chushiyan.bos.pojo;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 用户实体类
 */
@Data
@Entity
@Table(name = "bos_user")
@EqualsAndHashCode(exclude = {"roles"}) // 忽略roles属性，否则出现死循环
@ToString(exclude = {"roles"})   // 忽略roles属性，否则出现死循环

public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "user_name")
    private String name;

    @JsonIgnore
    @Column(name = "user_password")
    private String password;

    @Column(name = "user_status")
    private Integer status;

    @JsonIgnoreProperties(value = {"users", "privileges"})
    @ManyToMany(targetEntity = Role.class)
    @JoinTable(
            name = "user_role_ref", // 中间表的名称
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<Role> roles = new HashSet<Role>();

}
