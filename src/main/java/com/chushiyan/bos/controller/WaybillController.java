package com.chushiyan.bos.controller;

import com.chushiyan.bos.entity.Result;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.entity.StatusCode;
import com.chushiyan.bos.pojo.Waybill;
import com.chushiyan.bos.queryvo.WaybillQueryVo;
import com.chushiyan.bos.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description 运单controller
 */
@RestController
@CrossOrigin
@RequestMapping("/waybill")
public class WaybillController {

    @Autowired
    private WaybillService waybillService;


    /**
     * 添加运单
     *
     * @param queryVo
     * @return
     */
    @PostMapping
    public Result add(@Validated @RequestBody WaybillQueryVo queryVo) {
        waybillService.add(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.ADD_OK);
    }

    /**
     * 根据 id 删除运单
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id) {
        waybillService.deleteById(id);
        return new Result(true, StatusCode.OK, ResultMessage.DELETE_OK);
    }


    /**
     * 修改运单
     *
     * @param id
     * @param queryVo
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable String id, @Validated @RequestBody WaybillQueryVo queryVo) {
        queryVo.setId(id);
        waybillService.update(queryVo);
        return new Result(true, StatusCode.OK, ResultMessage.UPDATE_OK);
    }

    /**
     *  根据 id 查询运单
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true,StatusCode.OK,ResultMessage.FOUND_OK,waybillService.findById(id));
    }


//    TODO
    public Result search(){

        return null;
    }


}


