package com.chushiyan.bos.queryvo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
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
public class LinkmanQueryVo implements Serializable {

    private String id;

    @NotNull(message = "姓名不能为空")
    @Size(min = 2, max = 20, message = "姓名长度必须在2-20之间")
    private String name;

    @Range(min = 0, max = 1, message = "联系人gender属性值非法")
    private Integer gender;  // 0: female    1: male

    @NotNull(message = "联系人手机号码不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))[\\d]{8}$",
            message = "手机号码格式非法")
    private String phone;


    private String mobile;

    @Email(message = "邮箱格式非法")
    private String email;

    private String position;

    private String memo;

    @Range(min = 0, max = 1, message = "联系人status属性值非法")
    private Integer status;

    @NotNull(message = "联系人所属公司不能为空")
    private String customerId;

}
