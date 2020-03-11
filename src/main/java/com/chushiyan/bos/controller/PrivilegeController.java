package com.chushiyan.bos.controller;

import com.chushiyan.bos.entity.PageResult;
import com.chushiyan.bos.entity.Result;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.entity.StatusCode;
import com.chushiyan.bos.pojo.Privilege;
import com.chushiyan.bos.service.PrivilegeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 权限controller
 */
@RequestMapping("/privilege")
@CrossOrigin
@RestController
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    /**
     * 根据id 查询权限
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @RequiresPermissions("privilege-find")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, privilegeService.findById(id));
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/{page}/{size}")
    public Result paging(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Privilege> pageList = privilegeService.paging(page, size);

        if(pageList.getSize() == 0){
            return new Result(false,StatusCode.ERROR,ResultMessage.FOUND_ERROR);
        }

        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK,
                new PageResult<Privilege>(pageList.getTotalElements(), pageList.getContent()));
    }


}
