package com.chushiyan.bos.dao;

import com.chushiyan.bos.pojo.Linkman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
public interface LinkmanDao extends JpaRepository<Linkman, String>, JpaSpecificationExecutor<Linkman> {

    @Query("update Customer set status = ?1 where id = ?2")
    @Modifying
    public void updateStatus(Integer status, String id);

}
