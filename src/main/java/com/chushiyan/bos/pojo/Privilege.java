package com.chushiyan.bos.pojo;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
 * @description 权限实体类
 */
@Data
@Entity
@Table(name = "bos_privilege")
@EqualsAndHashCode(exclude = {"roles", "parent", "children"})  // 忽略roles属性，否则出现死循环
@ToString(exclude = {"roles", "parent", "children"})           // 忽略roles属性，否则出现死循环

public class Privilege implements Serializable {

    @Id
    @Column(name = "privilege_id")
    private String id; // varchar(32) not null,

    @Column(name = "privilege_name")
    private String name; // varchar(255) comment '权限名称',

    @Column(name = "privilege_description")
    private String description; // varchar(255) comment '权限描述',

    @Column(name = "privilege_path")
    private String path; // varchar(255) comment '权限的路径',

    @Column(name = "privilege_status")
    private Integer status; // bit comment '状态。0：弃用。1：使用中',

    @JsonIgnore
    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles = new HashSet<Role>();


    @ManyToOne
    @JoinColumn(name = "privilege_parent_id", referencedColumnName = "privilege_id")
    private Privilege parent;

    @JsonIgnoreProperties(value = "parent")
    @OneToMany(mappedBy = "parent")
    private Set<Privilege> children = new HashSet<Privilege>();


}

