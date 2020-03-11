package com.chushiyan.bos.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 订单项实体类
 */
@Data
@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {
    @Id
    @Column(name = "order_item_id")
    //varchar(100) not null comment '订单编号。人工指定',
    private String id;

    @Column(name = "shipping_date")
    // date comment '发车日期',
    private Date shippingDate;

    @Column(name = "packaging_type")
    //varchar(20) comment '包装方式',
    private String packagingType;

    @Column(name = "weight")
    //double,货物重量
    private Double weight;

    @Column(name = "volume")
    //double,货物体积
    private Double volume;

    @Column(name = "packages_number")
    //int comment '件数',
    private Integer packagesNumber;

    @Column(name = "goods_name")
    //varchar(15) comment '货名',
    private String goodsName;

    @Column(name = "shipping_address")
    //varchar(100) comment '货物收货地址',
    private String shippingAddress;

    @Column(name = "receiver")
    //varchar(20) comment '收货人',
    private String receiver;

    @Column(name = "receiver_phone")
    //varchar(20) comment '收货人手机、电话',
    private String receiverPhone;

    @Column(name = "freight")
    //int comment '运费。单位：分',
    private Integer freight;

    @Column(name = "daofukuan")
    //int comment '到付款',单位：分',
    private Integer daofukuan;


    @Column(name = "short_barge_fee")
    //int comment '短驳费。',
    private Integer shortBargeFee;

    @Column(name = "memo")
    //varchar(100) comment '备注',
    private String memo;

    @Column(name = "order_status")

    //int comment '订单项状态。0：已删除。 1：已收件。 2：运输中。 3：派送中。 4：已完成',
    private Integer status;


    // 配置和运单的多对一关系
    // 一个运单包含多个订单项
//    @OneToMany(targetEntity = Waybill.class)
//    @JoinColumn(name = "waybill_id", referencedColumnName = "waybill_id")
    //@OneToMany(mappedBy = "orderItems")
    //@ManyToOne(mappedBy = "orderItems")
    @ManyToOne(targetEntity=Waybill.class)
    @JoinColumn(name = "waybill_id", referencedColumnName = "waybill_id")
    private Waybill waybill;


    // 配置和客户的多对一关系
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;


    // 配置和短驳车司机的多对多关系
    @ManyToMany(targetEntity = ShortDriver.class)
    @JoinTable(
            name = "short_driver_order_item_ref",
            joinColumns = {@JoinColumn(name = "order_item_id", referencedColumnName = "order_item_id")},
            inverseJoinColumns = {@JoinColumn(name = "driver_id", referencedColumnName = "driver_id")}
    )
    private Set<ShortDriver> shortDrivers = new HashSet<ShortDriver>();


}
