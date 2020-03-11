package com.chushiyan.bos.dao;

import com.chushiyan.bos.pojo.TrailerDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chushiyan
 * @email Y2h1c2hpeWFuMDQxNUAxNjMuY29t(base64)
 * @description
 */

public interface TrailerDriverDao extends JpaRepository<TrailerDriver, String>, JpaSpecificationExecutor<TrailerDriver> {

    @Query("update TrailerDriver set status= ?1 where id = ?2")
    @Modifying
    public void updateStatus(Integer status, String id);
}
