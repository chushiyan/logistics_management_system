package com.chushiyan.bos.controller;

import com.chushiyan.bos.entity.*;
import com.chushiyan.bos.pojo.Customer;
import com.chushiyan.bos.queryvo.CustomerQueryVo;
import com.chushiyan.bos.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 增加客户
     *
     * @param customerQueryVo
     * @return
     */
    @PostMapping
    private Result add(@Validated  @RequestBody CustomerQueryVo customerQueryVo) {
        customerService.add(customerQueryVo);
        return new Result(true, StatusCode.OK, ResultMessage.ADD_OK);
    }

    /**
     * 根据id逻辑删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id) {
        customerService.deleteById(id);
        return new Result(true, StatusCode.OK, ResultMessage.DELETE_OK);
    }


    /**
     * 修改客户
     *
     * @param id
     * @param queryVo
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @Validated @RequestBody CustomerQueryVo queryVo) {
        queryVo.setId(id);
        customerService.update(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.UPDATE_OK);
    }


    /**
     * 根据 id 查询客户
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, customerService.findById(id));
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
        Page<Customer> pageList = customerService.paging(page, size);
        if (pageList.getTotalElements() == 0) {
            return new Result(false, StatusCode.ERROR, ResultMessage.FOUND_ERROR);
        }
        PageResult<Customer> pageResult = new PageResult<Customer>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, pageResult);
    }



}


