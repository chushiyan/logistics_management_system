package com.chushiyan.bos.controller;

import com.chushiyan.bos.entity.*;
import com.chushiyan.bos.pojo.Linkman;
import com.chushiyan.bos.queryvo.LinkmanQueryVo;
import com.chushiyan.bos.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
@RestController
@CrossOrigin
@RequestMapping("/linkman")
public class LinkmanController {

    @Autowired
    private LinkmanService linkmanService;

    /**
     * 增加客户联系人
     *
     * @param queryVo
     * @return
     */
    @PostMapping
    public Result add(@Validated @RequestBody LinkmanQueryVo queryVo) {
        linkmanService.add(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.ADD_OK);
    }

    /**
     * 根据 id 删除客户联系人
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id) {
        linkmanService.deleteById(id);
        return new Result(true, StatusCode.OK, ResultMessage.DELETE_ERROR);
    }

    /**
     * 修改客户联系人
     *
     * @param id
     * @param queryVo
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @Validated @RequestBody LinkmanQueryVo queryVo) {
        queryVo.setId(id);
        linkmanService.update(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.UPDATE_OK);
    }

    /**
     * 根据 id 查询客户联系人
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, linkmanService.findById(id));
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/page/{page}/{size}")
    public Result paging(@PathVariable int page, @PathVariable int size) {
        Page<Linkman> pageList = linkmanService.paging(page, size);
        if (pageList.getTotalElements() == 0) {
            return new Result(false, StatusCode.ERROR, ResultMessage.FOUND_ERROR);
        }
        PageResult<Linkman> pageResult = new PageResult<Linkman>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, pageResult);
    }
}