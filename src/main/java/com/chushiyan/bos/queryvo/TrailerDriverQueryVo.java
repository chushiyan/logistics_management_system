package com.chushiyan.bos.queryvo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description
 */

@Data
public class TrailerDriverQueryVo implements Serializable {

    //       varchar(200) not null,
    private String id;

    @NotNull(message = "挂车司机姓名不能为空")
    //    varchar(10) comment '挂车司机姓名',
    private String name;

    //  varchar(20) comment '司机身份证',
    @NotNull(message = "挂车司机身份证不能为空")
    @Size(min = 18, max = 18, message = "身份证号码长度必须为18")
    private String idCard;

    //   varchar(11) comment '司机手机',
    @NotNull(message = "挂车司机手机号码不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))[\\d]{8}$",
            message = "手机号码格式非法")
    private String phone;

    //   varchar(100),
    private String weChat;

    @NotNull(message = "挂车车牌号不能为空")
    //      varchar(20) comment '车牌号',
    private String carNumber;

    @Range(min = 10, max = 30, message = "挂车长度非法")
    //      double comment '车厢长度',
    private Double carLength;

    @Range(min = 3, max = 6, message = "挂车高度非法")
    //      double comment '车厢高度',
    private Double carHeight;

    @Range(min = 2, max = 6, message = "挂车宽度非法")
    //       double comment '车厢宽度',
    private Double carWidth;

    @Range(min = 10, max = 45, message = "挂车总载重非法")
    //        double comment '总载重',
    private Double carLoad;

    @Range(min = 200, max = 450, message = "挂车体积非法")
    //      double comment '车厢体积',
    private Double carVolume;

    //   int default 1,   0：删除。 1：正常
    private Integer status;

    private String[] waybills;


}
