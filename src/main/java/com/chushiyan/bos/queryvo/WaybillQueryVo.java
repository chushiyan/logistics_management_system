package com.chushiyan.bos.queryvo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description
 */
@Data
public class WaybillQueryVo implements Serializable {

    private String id;             //varchar(200) not null,

    @NotNull(message = "发车日期不能为空")
    private Date departureDate;       //date comment '发车日期',

    @NotNull(message = "结算方式不能为空")
    private String settlementMethod;    //varchar(10) comment '结算方式：预付、回结、预付回结、到付、预付到付',

    @Digits(integer = 8, fraction = 0,message = "必须是8位以内的正整数")
    private Integer yufukuan;             //int comment '预付款。单位：分',

    @Digits(integer = 8, fraction = 0,message = "必须是8位以内的正整数")
    private Integer daofukuan;            //int comment '到付款。单位：分',


    @Digits(integer = 8, fraction = 0,message = "必须是8位以内的正整数")
    private Integer huijiekuan;           //int comment '回单结算运费。Return bill check freight',

    @NotNull(message = "协议编号不能为空")
    private String agreementNun;        //varchar(50) comment '协议编号',


    @Range(min = 0, max = 1, message = "运单状态值不能为空")
    private Integer status;      // int comment '运单状态。0：删除。  1：正常',

    // 订单
    @NotBlank(message = "运单所属订单项不能为空")
    private String[] orderItems;

    @NotNull(message = "挂车司机不能为空")
    // 挂车司机
    private String trailerDriver;

}
