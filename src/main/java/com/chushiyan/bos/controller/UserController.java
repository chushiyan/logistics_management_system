package com.chushiyan.bos.controller;

import com.chushiyan.bos.entity.*;
import com.chushiyan.bos.pojo.User;
import com.chushiyan.bos.queryvo.UserQueryVo;
import com.chushiyan.bos.service.UserService;
import com.chushiyan.bos.utils.JwtUtil;
import com.chushiyan.bos.validate.GroupA;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 用户Controller
 */
@RestController
@CrossOrigin
//@RequestMapping("/user")
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;


    /**
     * 增加用户
     *
     * @param queryVo
     * @return
     */
    @PostMapping("/user")
    @RequiresPermissions("user-add")
    public Result add(@Valid @RequestBody UserQueryVo queryVo) {
        userService.add(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.ADD_OK);
    }

    /**
     * 逻辑删除，将status修改为0
     *
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    @RequiresPermissions("user-delete")
    public Result deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return new Result(true, StatusCode.OK, ResultMessage.DELETE_OK);
    }

    /**
     * 修改用户
     *
     * @param id
     * @param queryVo
     * @return
     */
    @PutMapping("/user/{id}")
    @RequiresPermissions("user-update")
    public Result updateById(@PathVariable String id, @Validated({GroupA.class, Default.class}) @RequestBody UserQueryVo queryVo) {
        queryVo.setId(id);
        userService.updateById(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.UPDATE_OK);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    @RequiresPermissions("user-find")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, userService.findById(id));
    }


    /**
     * 分页查询
     *
     * @return
     */
    @GetMapping("/user/page/{page}/{size}")
    @RequiresPermissions("user-find")
    public Result paging(@PathVariable int page, @PathVariable int size) {

        Page<User> pageList = userService.paging(page, size);

        if (pageList.getSize() == 0) {
            return new Result(false, StatusCode.ERROR, ResultMessage.FOUND_ERROR);
        }
        PageResult<User> pageResult = new PageResult<User>(pageList.getTotalElements(), pageList.getContent());

        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, pageResult);
    }


    /**
     * 用户登录
     *
     * @param userQueryVo
     * @return
     */
    @PostMapping("/user/login")
    public Result login(@RequestBody UserQueryVo userQueryVo) {

        User user = userService.login(userQueryVo);

        // 将用户id name都写入jwt
        String token = jwtUtil.createJWT(user.getId(), user.getName());

        Map<String, String> map = new HashMap<String, String>();
        map.put("token", token);
        map.put("id", user.getId());
        map.put("name", user.getName());
        return new Result(true, StatusCode.OK, ResultMessage.LOGIN_OK, map);


    }


    @RequestMapping("/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)  // 指定 401 状态码
    public Result unauthorized() {
        return new Result(false, StatusCode.ERROR, ResultMessage.UNAUTHORIZED);
    }

}

