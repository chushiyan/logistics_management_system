package com.chushiyan.bos.dao;

import com.chushiyan.bos.pojo.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description
 */

public interface OrderItemDao extends JpaRepository<OrderItem,String>, JpaSpecificationExecutor<OrderItem> {


    @Query("update OrderItem set status = ?1 where id = ?2")
    @Modifying
    void updateStatus(Integer status, String id);
}
