package com.chushiyan.bos.service;

import com.chushiyan.bos.dao.PrivilegeDao;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.pojo.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 权限service
 */
@Service
@Transactional
public class PrivilegeService {

    @Autowired
    private PrivilegeDao privilegeDao;


    // 根据 id 查询
    public Privilege findById(String id) {

        Optional optional = privilegeDao.findById(id);
        if(!optional.isPresent()){
            throw new RuntimeException(ResultMessage.PRIVILEGE_NOT_FOUND);
        }
        return (Privilege) optional.get();
    }


    // 分页查询
    public Page<Privilege> paging(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("name").descending());
        return privilegeDao.findAll(pageable);
    }
}
