package com.chushiyan.bos.queryvo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
@Data
public class CustomerQueryVo implements Serializable {

    private String id;

    @NotNull(message = "客户名称不能为空")
    private String name;

    private String fullName;

    @NotNull(message = "客户地址不能为空")
    private String address;

    @Range(min = 0, max = 1, message = "客户status属性值非法")
    private Integer status;


    private String[] linkmen;

}
