package com.chushiyan.bos.service;

import com.chushiyan.bos.dao.OrderItemDao;
import com.chushiyan.bos.dao.TrailerDriverDao;
import com.chushiyan.bos.dao.WaybillDao;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.pojo.OrderItem;
import com.chushiyan.bos.pojo.Waybill;
import com.chushiyan.bos.queryvo.WaybillQueryVo;
import com.chushiyan.bos.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description 运单service
 */
@Service
@Transactional
public class WaybillService {

    @Autowired
    private WaybillDao waybillDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private TrailerDriverDao trailerDriverDao;

    @Autowired
    private IdWorker idWorker;


    // 增加
    public void add(WaybillQueryVo queryVo) {

        Waybill waybill = new Waybill();

        // id
        waybill.setId(String.valueOf(idWorker.nextId()));

        // 发车日期
        waybill.setDepartureDate(queryVo.getDepartureDate());

        // 结算方式
        waybill.setSettlementMethod(queryVo.getSettlementMethod());

        // 预付款
        waybill.setYufukuan(queryVo.getYufukuan());

        // 到付款
        waybill.setDaofukuan(queryVo.getDaofukuan());

        // 回结款
        waybill.setHuijiekuan(queryVo.getHuijiekuan());

        // 协议编号
        waybill.setAgreementNun(queryVo.getAgreementNun());

        // 状态
        waybill.setStatus(1);

        // 订单项
        Set<OrderItem> orderItems = new HashSet<OrderItem>();
        if (queryVo.getOrderItems().length > 0) {
            for (String orderItemId : queryVo.getOrderItems()) {
                orderItems.add(orderItemDao.findById(orderItemId).orElse(null));
            }
            waybill.setOrderItems(orderItems);
        }

        // 挂车司机
        waybill.setTrailerDriver(trailerDriverDao.findById(queryVo.getTrailerDriver()).orElse(null));

        waybillDao.save(waybill);

    }


    // 逻辑删除
    public void deleteById(String id) {
        waybillDao.updateStatus(0,id);
    }

    // 修改
    public void update(WaybillQueryVo queryVo) {

        Optional optional = waybillDao.findById(queryVo.getId());

        if(!optional.isPresent()){
            throw  new RuntimeException(ResultMessage.WAYBILL_NOT_FOUND);
        }

        Waybill waybill = (Waybill) optional.get();

        // 发车日期
        waybill.setDepartureDate(queryVo.getDepartureDate());

        // 结算方式
        waybill.setSettlementMethod(queryVo.getSettlementMethod());

        // 预付款
        waybill.setYufukuan(queryVo.getYufukuan());

        // 到付款
        waybill.setDaofukuan(queryVo.getDaofukuan());

        // 回结款
        waybill.setHuijiekuan(queryVo.getHuijiekuan());

        // 协议编号
        waybill.setAgreementNun(queryVo.getAgreementNun());

        // 状态
        waybill.setStatus(queryVo.getStatus());

        // 订单项
        Set<OrderItem> orderItems = new HashSet<OrderItem>();
        if (queryVo.getOrderItems().length > 0) {
            for (String orderItemId : queryVo.getOrderItems()) {
                orderItems.add(orderItemDao.findById(orderItemId).orElse(null));
            }
            waybill.setOrderItems(orderItems);
        }

        // 挂车司机
        waybill.setTrailerDriver(trailerDriverDao.findById(queryVo.getTrailerDriver()).orElse(null));

        waybillDao.save(waybill);
    }




    public Waybill findById(String id) {
        Optional optional =waybillDao.findById(id);
        if(!optional.isPresent()){
            throw  new RuntimeException(ResultMessage.WAYBILL_NOT_FOUND);
        }
        return (Waybill) optional.get();
    }
}
