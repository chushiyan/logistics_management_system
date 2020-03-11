package com.chushiyan.bos.controller;

import com.chushiyan.bos.entity.PageResult;
import com.chushiyan.bos.entity.Result;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.entity.StatusCode;
import com.chushiyan.bos.pojo.TrailerDriver;
import com.chushiyan.bos.queryvo.ShortDriverQueryVo;
import com.chushiyan.bos.queryvo.TrailerDriverQueryVo;
import com.chushiyan.bos.service.TrailerDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description 挂车司机控制器
 */

@RestController
@CrossOrigin
@RequestMapping("/trailer-driver")
public class TrailerDriverController {

    @Autowired
    private TrailerDriverService trailerDriverService;


    /**
     * 增加挂车司机
     *
     * @param queryVo
     * @return
     */
    @PostMapping
    public Result add(@Validated @RequestBody TrailerDriverQueryVo queryVo) {
        trailerDriverService.add(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.ADD_OK);
    }

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id) {
        trailerDriverService.deleteById(id);
        return new Result(true, StatusCode.OK, ResultMessage.DELETE_OK);
    }

    /**
     * 修改
     *
     * @param id
     * @param queryVo
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @Validated @RequestBody TrailerDriverQueryVo queryVo) {
        queryVo.setId(id);
        trailerDriverService.update(queryVo);
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
        return new Result(true, StatusCode.OK, ResultMessage.FOUND_OK, trailerDriverService.findById(id));
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

        Page<TrailerDriver> pageList = trailerDriverService.paging(page, size);
        if (pageList.getSize() == 0) {
            return new Result(false, StatusCode.ERROR, ResultMessage.FOUND_ERROR);
        }

        return new Result(true,
                StatusCode.OK,
                ResultMessage.FOUND_OK,
                new PageResult<TrailerDriver>(pageList.getTotalElements(), pageList.getContent())
        );
    }

    /**
     * 分页条件查询
     *
     * @param page
     * @param size
     * @param queryVo
     * @return
     */
    @GetMapping("/search/{page}/{size}")
    public Result search(@PathVariable int page, @PathVariable int size,  @RequestBody TrailerDriverQueryVo queryVo) {

        Page<TrailerDriver> pageList = trailerDriverService.search(page, size, queryVo);
        if (pageList.getSize() == 0) {
            return new Result(false, StatusCode.ERROR, ResultMessage.FOUND_ERROR);
        }
        return new Result(true,
                StatusCode.OK,
                ResultMessage.FOUND_OK,
                new PageResult<TrailerDriver>(pageList.getTotalElements(), pageList.getContent())
        );
    }
}
