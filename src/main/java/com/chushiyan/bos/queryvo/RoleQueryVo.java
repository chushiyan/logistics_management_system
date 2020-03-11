package com.chushiyan.bos.queryvo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
@Data
public class RoleQueryVo implements Serializable {

    private String id;

    @NotNull(message = "角色名称不能为空")
    @Size(min = 2, max = 10, message = "角色名称长度必须在2-10之间")
    private String name;

    @Size(min = 1, max = 255, message = "角色描述长度必须在1-255之间")
    private String description;

    @Range(min = 0, max = 1, message = "角色status属性值非法")
    private Integer status;

    private String[] privilegeIds;
}
