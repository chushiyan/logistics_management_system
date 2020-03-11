package com.chushiyan.bos.service;

import com.chushiyan.bos.dao.PrivilegeDao;
import com.chushiyan.bos.dao.RoleDao;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.queryvo.RoleQueryVo;
import com.chushiyan.bos.pojo.Privilege;
import com.chushiyan.bos.pojo.Role;
import com.chushiyan.bos.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
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
 * @description 角色service
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PrivilegeDao privilegeDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 添加角色
     *
     * @param roleQueryVo
     */
    public void add(RoleQueryVo roleQueryVo) {
        // 先查询是否已经存在相同name的角色，存在则抛出异常
        Role roleFromDB = roleDao.findRoleByNameAndStatus(roleQueryVo.getName(), 1);
        if (roleFromDB != null) {
            throw new RuntimeException(ResultMessage.ROLE_NAME_DUPLICATED);
        }

        Role role = new Role();
        role.setId(String.valueOf(idWorker.nextId()));
        role.setName(roleQueryVo.getName());
        role.setDescription(roleQueryVo.getDescription());

        if (roleQueryVo.getPrivilegeIds() != null && roleQueryVo.getPrivilegeIds().length > 0) {
            for (String privilegeId : roleQueryVo.getPrivilegeIds()) {
                Optional<Privilege> optional = privilegeDao.findById(privilegeId);
                if (optional.isPresent()) {
                    role.getPrivileges().add(optional.get());
                }
            }
        }
        roleDao.save(role);
    }


    /**
     * 逻辑删除角色
     *
     * @param id
     */
    public void deleteById(String id) {
        roleDao.updateStatus(0, id);
    }


    /**
     * 修改角色
     *
     * @param roleQueryVo
     */
    public void update(RoleQueryVo roleQueryVo) {

        // 先查询是否已经存在相同name的角色，存在则抛出异常
        Role roleFromDB = roleDao.findRoleByNameAndStatus(roleQueryVo.getName(), 1);

        if (roleFromDB != null) {
            throw new RuntimeException(ResultMessage.ROLE_NAME_DUPLICATED);
        }

        Optional<Role> roleOptional = roleDao.findById(roleQueryVo.getId());
        if (!roleOptional.isPresent()) {
            throw new RuntimeException(ResultMessage.ROLE_NOT_FOUND);
        }
        Role role = roleOptional.get();

        role.setName(roleQueryVo.getName());

        role.setDescription(roleQueryVo.getDescription());

        role.setStatus(roleQueryVo.getStatus());

        roleDao.save(role);

    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public Role findById(String id) {

        Optional optional = roleDao.findById(id);

        if(!optional.isPresent()){

            throw new RuntimeException(ResultMessage.ROLE_NOT_FOUND);
        }
        return (Role)optional.get();
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    public Page<Role> paging(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("name").descending());
        return roleDao.findAll(pageable);
    }


}
