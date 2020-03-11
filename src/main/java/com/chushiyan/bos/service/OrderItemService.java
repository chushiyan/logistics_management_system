package com.chushiyan.bos.service;

import com.chushiyan.bos.dao.CustomerDao;
import com.chushiyan.bos.dao.OrderItemDao;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.pojo.Customer;
import com.chushiyan.bos.pojo.OrderItem;
import com.chushiyan.bos.queryvo.OrderItemQueryVo;
import com.chushiyan.bos.utils.IdWorker;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description
 */
@Service
@Transactional
public class OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private IdWorker idWorker;

    // 增加
    public void add(OrderItemQueryVo queryVo) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(String.valueOf(idWorker.nextId()));
        queryVoToEntity(orderItem, queryVo);
        orderItem.setStatus(1);
        orderItemDao.save(orderItem);
    }

    private void queryVoToEntity(OrderItem orderItem, OrderItemQueryVo queryVo) {
        orderItem.setShippingDate(queryVo.getShippingDate());
        orderItem.setPackagingType(queryVo.getPackagingType());
        orderItem.setWeight(queryVo.getWeight());
        orderItem.setVolume(queryVo.getVolume());
        orderItem.setPackagesNumber(queryVo.getPackagesNumber());
        orderItem.setGoodsName(queryVo.getGoodsName());
        orderItem.setShippingAddress(queryVo.getShippingAddress());
        orderItem.setReceiver(queryVo.getReceiver());
        orderItem.setReceiverPhone(queryVo.getReceiverPhone());
        orderItem.setFreight(queryVo.getFreight());
        orderItem.setDaofukuan(queryVo.getDaofukuan());
        orderItem.setShortBargeFee(queryVo.getShortBargeFee());
        orderItem.setMemo(queryVo.getMemo());
        if (StringUtils.isNotEmpty(queryVo.getCustomer())) {
            Optional optional = customerDao.findById(queryVo.getCustomer());
            if (optional.isPresent()) {
                orderItem.setCustomer((Customer) optional.get());
            }
        }
    }

    // 逻辑删除
    public void deleteById(String id) {
        orderItemDao.updateStatus(0, id);
    }


    // 修改
    public void update(OrderItemQueryVo queryVo) {
        OrderItem orderItem = new OrderItem();
        queryVoToEntity(orderItem, queryVo);
        orderItem.setStatus(queryVo.getStatus());
        orderItemDao.save(orderItem);
    }


    // 根据 id 查询
    public OrderItem findById(String id) {
        Optional optional = orderItemDao.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException(ResultMessage.ORDERITEM_NOT_FOUND);
        }
        return (OrderItem) optional.get();

    }

    // 分页查询
    public Page<OrderItem> paging(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by("shippingDate"));
        return orderItemDao.findAll(pageRequest);
    }


    // 分页条件查询
    public Page<OrderItem> search(int page, int size, OrderItemQueryVo queryVo) {

        Specification<OrderItem> specification = new Specification<OrderItem>() {
            @Override
            public Predicate toPredicate(Root<OrderItem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicateList = new ArrayList<Predicate>();

                // 根据收货人查询
                if (StringUtils.isNotEmpty(queryVo.getReceiver())) {
                    predicateList.add(criteriaBuilder.like(root.get("receiver").as(String.class),
                            "%" + queryVo.getReceiver() + "%"));
                }

                // 根据状态值查询
                if (queryVo.getStatus() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("status").as(String.class),
                            queryVo.getStatus()));
                }


                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));

            }
        };

        PageRequest pageRequest = PageRequest.of(page - 1, size,Sort.by("shippingDate"));

        return orderItemDao.findAll(specification,pageRequest);

    }
}
