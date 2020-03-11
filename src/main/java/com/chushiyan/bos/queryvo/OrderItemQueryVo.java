package com.chushiyan.bos.queryvo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description
 */
@Data
public class OrderItemQueryVo implements Serializable {

    private String id;

    @NotNull(message = "发车日期不能为空")
    @PastOrPresent
    // date comment '发车日期',
    private Date shippingDate;

    //varchar(20) comment '包装方式',
    private String packagingType;

    @NotNull(message = "货物重量不能为空")
    //double,货物重量
    private Double weight;


    //double,货物体积
    private Double volume;

    @NotNull(message = "货物件数不能为空")
    //int comment '件数',
    private Integer packagesNumber;

    //varchar(15) comment '货名',
    private String goodsName;

    @NotNull(message = "收货地址不能为空")
    //varchar(100) comment '货物收货地址',
    private String shippingAddress;

    @NotNull(message = "收货人不能为空")
    //varchar(20) comment '收货人',
    private String receiver;

    @NotNull(message = "收货人手机不能为空")
    //varchar(20) comment '收货人手机、电话',
    private String receiverPhone;


    //int comment '运费。单位：分',
    private Integer freight;


    //int comment '到付款',单位：分',
    private Integer daofukuan;

    // 短驳费

    private Integer shortBargeFee;

    // 备注
    @Size(min = 1,max = 50,message = "备注字数必须在1-50之间")
    private String memo;

    @Range(min = 0,max = 1,message = "订单项状态值必须是0或1")
    private Integer status;



    private String waybill;


    private String customer;


    private String[] shortDrivers;

}
