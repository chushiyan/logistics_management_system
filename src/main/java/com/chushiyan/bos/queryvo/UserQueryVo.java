package com.chushiyan.bos.queryvo;

import com.chushiyan.bos.validate.GroupA;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UserQueryVo implements Serializable {

    private String id;

    @NotNull(message = "姓名不能为空")
    @Size(min = 1, max = 20, message = "姓名长度必须在1-20之间")
    private String name;

    @NotNull(message = "密码不能为空")
    @Size(min = 12, max = 20, message = "密码长度必须在12-20之间")
    private String password;

    @NotNull(message = "用户status属性值不能为空",groups = GroupA.class)
    @Range(min = 0, max = 1, message = "用户status属性值非法")
    private Integer status;

    private String[] roles;

}
