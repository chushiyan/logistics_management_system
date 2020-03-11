package com.chushiyan.bos.pojo;

import com.sun.javafx.beans.IDProperty;
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
 * @description 客户实体类
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {"linkmen", "orderItems"})
@ToString(exclude = {"linkmen", "orderItems"})
public class Customer implements Serializable {

    @Id
    @Column(name = "customer_id")
    private String id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_fullname")
    private String fullName;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_status")
    private Integer status;

    // 配置和联系人的一对多关系
    @OneToMany(mappedBy = "customer")
    private Set<Linkman> linkmen = new HashSet<Linkman>();


    // 配置和订单的一对多关系
    @OneToMany(mappedBy = "customer")
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();


}
