package com.chushiyan.bos.controller;

import com.chushiyan.bos.entity.PageResult;
import com.chushiyan.bos.entity.Result;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.entity.StatusCode;
import com.chushiyan.bos.pojo.OrderItem;
import com.chushiyan.bos.queryvo.OrderItemQueryVo;
import com.chushiyan.bos.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import javax.swing.plaf.nimbus.State;
import javax.validation.Valid;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description
 */
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    /**
     * 增加订单
     *
     * @param queryVo
     * @return
     */
    @PostMapping
    public Result add(@Valid @RequestBody OrderItemQueryVo queryVo) {
        orderItemService.add(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.ADD_OK);
    }

    /**
     * 逻辑删除订单
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id) {
        orderItemService.deleteById(id);
        return new Result(true, StatusCode.OK, ResultMessage.DELETE_OK);
    }

    /**
     * 修改订单
     *
     * @param id
     * @param queryVo
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @Validated @RequestBody OrderItemQueryVo queryVo) {
        queryVo.setId(id);
        orderItemService.update(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.UPDATE_OK);
    }

    /**
     * 根据 id 查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, orderItemService.findById(id));
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

        Page<OrderItem> pageList = orderItemService.paging(page, size);

        if (pageList.getSize() == 0) {
            return new Result(false, StatusCode.ERROR, ResultMessage.FOUND_ERROR);
        }

        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK,
                new PageResult<OrderItem>(pageList.getTotalElements(), pageList.getContent())
        );
    }

    // 分页条件查询
    @GetMapping("/search/{page}/{size}")
    public Result search(@PathVariable int page, @PathVariable int size, @RequestBody OrderItemQueryVo queryVo) {

        Page<OrderItem> pageList = orderItemService.search(page, size, queryVo);

        if (pageList.getSize() == 0) {
            return new Result(false, StatusCode.ERROR, ResultMessage.FOUND_ERROR);
        }

        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK,
                new PageResult<OrderItem>(pageList.getTotalElements(), pageList.getContent())
        );
    }
}
