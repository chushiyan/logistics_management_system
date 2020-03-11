package com.chushiyan.bos.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 短驳车司机实体类
 */

@Data
@Entity
@Table(name = "short_driver")
public class ShortDriver implements Serializable {

    @Id
    @Column(name = "driver_id")
    //  varchar(200) not null,
    private String id;

    @Column(name = "driver_name")
    //  varchar(10) comment '司机姓名',
    private String name;

    @Column(name = "driver_id_card")
    //  varchar(20) comment '司机身份证号',
    private String idCard;

    @Column(name = "driver_phone  ")
    //  varchar(11) comment '司机手机号',
    private String phone;

    @Column(name = "driver_wechat ")
    //   varchar(100) comment '司机微信号',
    private String weChat;

    @Column(name = "car_number    ")
    //   varchar(20) comment '车牌号',
    private String carNumber;

    @Column(name = "car_length    ")
    //   double comment '车厢长度',
    private Double carLength;

    @Column(name = "car_height    ")
    //   double comment '车厢高度',
    private Double carHeight;

    @Column(name = "car_width     ")
    //   double comment '车厢宽度',
    private Double carWidth;

    @Column(name = "car_load      ")
    //   double comment '载重',
    private Double carLoad;

    @Column(name = "car_volume    ")
    //   double comment '车厢体积',
    private Double carVolume;

    @Column(name = "car_type      ")
    //   varchar(100) comment '车牌类型：0:绿牌、1:蓝牌、2:黄牌',
    private Integer carType;

    @Column(name = "driver_status ")
    //   int, 0：删除。  1：正常
    private Integer status;


    // 配置和订单的多对多关系
    //
//    @JsonIgnoreProperties(value = {"shortDrivers"})
    @JsonIgnore
    @ManyToMany(mappedBy = "shortDrivers")
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();


}
