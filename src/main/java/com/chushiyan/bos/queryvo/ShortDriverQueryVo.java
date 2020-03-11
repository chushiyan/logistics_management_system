package com.chushiyan.bos.queryvo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
@Data
public class ShortDriverQueryVo implements Serializable {

    private String id;

    @NotNull(message = "短驳车司机姓名不能为空")
    private String name;

    @NotNull(message = "短驳车司机身份证不能为空")
    @Size(min = 18, max = 18, message = "身份证号码长度必须为18")
    private String idCard;

    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))[\\d]{8}$",
            message = "手机号码格式非法")
    private String phone;

    private String weChat;

    private String carNumber;

    @Range(min = 1, max = 12, message = "短驳车长度非法")
    private Double carLength;

    @Range(min = 1, max = 6, message = "短驳车高度非法")
    private Double carHeight;

    @Range(min = 1, max = 3, message = "短驳车宽度非法")
    private Double carWidth;

    @Range(min = 1, max = 20, message = "短驳车总载重非法")
    private Double carLoad;


    private Double carVolume;

    @Range(min = 0, max = 2, message = "短驳车类型值非法")
    private Integer carType;

    @Range(min = 0, max = 1, message = "短驳车司机status属性值非法")
    private Integer status;

}
