package com.chushiyan.bos.dao;

import com.chushiyan.bos.pojo.ShortDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
public interface ShortDriverDao extends JpaRepository<ShortDriver, String>, JpaSpecificationExecutor<ShortDriver> {

    @Query("update ShortDriver set status = ?1 where id = ?2")
    @Modifying
    public void updateStatus(Integer status,String id);
}
