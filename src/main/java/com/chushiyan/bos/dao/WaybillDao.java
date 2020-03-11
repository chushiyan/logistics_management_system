package com.chushiyan.bos.dao;

import com.chushiyan.bos.pojo.Waybill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description 运单dao
 */

public interface WaybillDao extends JpaRepository<Waybill,String> , JpaSpecificationExecutor<Waybill> {

    // 修改状态值
    @Query("update Waybill set status = ?1 where id = ?2")
    @Modifying
    public void updateStatus(int i, String id);
}
