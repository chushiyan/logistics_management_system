package com.chushiyan.bos.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
 * @description 角色实体类
 */
@Data
@Entity
@Table(name = "bos_role")
@EqualsAndHashCode(exclude = {"users", "privileges"}) // 忽略这两属性，否则出现死循环
@ToString(exclude = {"users", "privileges"})  // 忽略这两属性，否则出现死循环

public class Role implements Serializable {

    @Id
    @Column(name = "role_id")
    private String id;

    @Column(name = "role_name")
    private String name;


    @Column(name = "role_description")
    private String description;

    @Column(name = "role_status")
    private Integer status;

    //    @JsonIgnoreProperties("roles")
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.REFRESH}, mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<User>();


    @JsonIgnoreProperties("roles")
    @ManyToMany(targetEntity = Privilege.class, cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_privilege_ref", // 中间表的名称
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "privilege_id", referencedColumnName = "privilege_id")})
    private Set<Privilege> privileges = new HashSet<Privilege>();

}
