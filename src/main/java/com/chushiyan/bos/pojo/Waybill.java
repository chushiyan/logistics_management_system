package com.chushiyan.bos.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 运单实体类
 */
@Data
@Entity
//@EqualsAndHashCode(exclude = {"customer"})
//@ToString(exclude = {"customer"})
//@JsonIgnoreProperties(value = {"trailerDriver","orderItems"})
public class Waybill implements Serializable {


    @Id
    @Column(name = "waybill_id")
    private String id;             //varchar(200) not null,

    @Column(name = "departure_date")
    private Date departureDate;       //date comment '发车日期',

    @Column(name = "settlement_method")
    private String settlementMethod;    //varchar(10) comment '结算方式：预付、回结、预付回结、到付、预付到付',

    private Integer yufukuan;             //int comment '预付款。单位：分',
    private Integer daofukuan;            //int comment '到付款。单位：分',
    private Integer huijiekuan;           //int comment '回单结算运费。Return bill check freight',

    @Column(name = "agreement_nun")
    private String agreementNun;        //varchar(50) comment '协议编号',


    @Column(name = "waybill_status")
    private Integer status;      // int comment '运单状态。0：删除。  1：正常',


    // 配置和订单的一对多关系
   // @OneToMany(targetEntity = OrderItem.class)
    //@JoinColumn(name = "waybill_id", referencedColumnName = "waybill_id")
    @JsonIgnore
    @OneToMany(mappedBy = "waybill")
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();


    // 配置和挂车司机的一对多关系
    @JsonIgnore
    //@JsonIgnoreProperties(value = {"waybills"})
    @ManyToOne(targetEntity = TrailerDriver.class)
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    private TrailerDriver trailerDriver;


}
