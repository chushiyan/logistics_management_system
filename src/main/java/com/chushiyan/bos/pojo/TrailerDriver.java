package com.chushiyan.bos.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * @description 卡车司机实体类
 */
@Data
@Entity
//@ToString(exclude = {"waybills"})
//@EqualsAndHashCode(exclude = {"waybills"})
@Table(name = "trailer_driver")
public class TrailerDriver  implements Serializable {

    @Id
    @Column(name = "driver_id")
    //       varchar(200) not null,
    private String id;

    @Column(name = "driver_name")
    //    varchar(10) comment '挂车司机姓名',
    private String name;

    @Column(name = "driver_id_card")
    //  varchar(20) comment '司机身份证',
    private String idCard;

    @Column(name = "driver_phone")
    //   varchar(11) comment '司机手机',
    private String phone;

    @Column(name = "driver_wechat")
    //   varchar(100),
    private String weChat;

    @Column(name = "car_number")
    //      varchar(20) comment '车牌号',
    private String carNumber;

    @Column(name = "car_length")
    //      double comment '车厢长度',
    private Double carLength;

    @Column(name = "car_height")
    //      double comment '车厢高度',
    private Double carHeight;

    @Column(name = "car_width")
    //       double comment '车厢宽度',
    private Double carWidth;

    @Column(name = "car_load")
    //        double comment '总载重',
    private Double carLoad;

    @Column(name = "car_volume")
    //      double comment '车厢体积',
    private Double carVolume;

    @Column(name = "driver_status")
    //   int default 1,   1：删除。 1：正常
    private Integer status;


    // 配置和运单的多对一关系
//    @JsonIgnoreProperties(value = {"trailerDriver","orderItems"})
    @JsonIgnore
    @OneToMany(mappedBy = "trailerDriver")
    private Set<Waybill> waybills;



}
