package com.chushiyan.bos.controller;

import com.chushiyan.bos.entity.PageResult;
import com.chushiyan.bos.entity.Result;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.entity.StatusCode;
import com.chushiyan.bos.pojo.ShortDriver;
import com.chushiyan.bos.queryvo.ShortDriverQueryVo;
import com.chushiyan.bos.queryvo.UserQueryVo;
import com.chushiyan.bos.service.ShortDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 短驳车司机控制器
 */
@RestController
@CrossOrigin
@RequestMapping("/short-driver")
public class ShortDriverController {

    @Autowired
    private ShortDriverService shortDriverService;


    // 增加
    @PostMapping
    public Result add(@Validated @RequestBody ShortDriverQueryVo queryVo) {
        shortDriverService.add(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.ADD_OK);
    }


    // 逻辑删除
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id) {
        shortDriverService.deleteById(id);
        return new Result(true, StatusCode.OK, ResultMessage.DELETE_OK);
    }

    // 修改短驳车司机
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @Validated @RequestBody ShortDriverQueryVo queryVo) {
        queryVo.setId(id);
        shortDriverService.update(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.UPDATE_OK);
    }

    // 根据 id 查询该短驳车司机
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, shortDriverService.findById(id));
    }

    // 分页查询
    @GetMapping("/page/{page}/{size}")
    public Result paging(@PathVariable int page, @PathVariable int size) {

        Page<ShortDriver> pageList = shortDriverService.paging(page, size);

        if (pageList.getSize() == 0) {
            return new Result(false, StatusCode.ERROR, ResultMessage.FOUND_ERROR);
        }

        PageResult<ShortDriver> pageResult = new PageResult<ShortDriver>(pageList.getTotalElements(), pageList.getContent());

        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, pageResult);
    }

    // 分页条件查询
    @GetMapping("/search/{page}/{size}")
    public Result search(@PathVariable int page, @PathVariable int size, @RequestBody ShortDriverQueryVo queryVo) {

        Page<ShortDriver> pageList = shortDriverService.search(queryVo, page, size);

        if (pageList.getSize() == 0) {
            return new Result(false, StatusCode.ERROR, ResultMessage.FOUND_ERROR);
        }

        return new Result(true,
                StatusCode.OK,
                ResultMessage.FOUND_OK,
                new PageResult<ShortDriver>(pageList.getTotalElements(), pageList.getContent())
        );
    }
}
