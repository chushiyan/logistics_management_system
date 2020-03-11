package com.chushiyan.bos.controller;


import com.chushiyan.bos.entity.*;
import com.chushiyan.bos.pojo.Role;
import com.chushiyan.bos.queryvo.RoleQueryVo;
import com.chushiyan.bos.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 角色controller
 */
@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 增加角色
     *
     * @param roleQueryVo
     * @return
     */
    @PostMapping
    @RequiresPermissions("role-add")
    public Result add(@Valid @RequestBody RoleQueryVo roleQueryVo) {
        roleService.add(roleQueryVo);
        return new Result(true, StatusCode.OK, ResultMessage.ADD_OK);
    }

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @RequiresPermissions("role-delete")
    public Result deleteById(@PathVariable String id) {
        roleService.deleteById(id);
        return new Result(true, StatusCode.OK, ResultMessage.DELETE_OK);
    }

    /**
     * 修改角色
     *
     * @param id
     * @param roleQueryVo
     * @return
     */
    @PutMapping("/{id}")
    @RequiresPermissions("role-update")
    public Result update(@PathVariable String id, @Valid @RequestBody RoleQueryVo roleQueryVo) {
        roleQueryVo.setId(id);
        roleService.update(roleQueryVo);
        return new Result(true, StatusCode.OK, ResultMessage.UPDATE_OK);
    }

    /**
     * 根据id 查询角色
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @RequiresPermissions("role-find")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, roleService.findById(id));
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/page/{page}/{size}")
    @RequiresPermissions("role-find")
    public Result paging(@PathVariable int page, @PathVariable int size) {
        Page<Role> pageList = roleService.paging(page, size);

        if (pageList.getSize() == 0) {
            return new Result(false, StatusCode.ERROR, ResultMessage.FOUND_ERROR);
        }
        PageResult<Role> pageResult = new PageResult<Role>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK);
    }

}
