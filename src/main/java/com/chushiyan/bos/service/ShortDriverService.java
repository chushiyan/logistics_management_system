package com.chushiyan.bos.service;

import com.chushiyan.bos.dao.ShortDriverDao;
import com.chushiyan.bos.entity.PageResult;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.pojo.ShortDriver;
import com.chushiyan.bos.queryvo.ShortDriverQueryVo;
import com.chushiyan.bos.utils.IdWorker;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
@Service
@Transactional
public class ShortDriverService {

    @Autowired
    private ShortDriverDao shortDriverDao;

    @Autowired
    private IdWorker idWorker;


    public void add(ShortDriverQueryVo queryVo) {

        ShortDriver shortDriver = new ShortDriver();

        shortDriver.setId(String.valueOf(idWorker.nextId()));

        shortDriver.setName(queryVo.getName());
        shortDriver.setIdCard(queryVo.getIdCard());
        shortDriver.setPhone(queryVo.getPhone());
        shortDriver.setWeChat(queryVo.getWeChat());
        shortDriver.setCarNumber(queryVo.getCarNumber());
        shortDriver.setCarLength(queryVo.getCarLength());

        shortDriver.setCarHeight(queryVo.getCarHeight());

        shortDriver.setCarWidth(queryVo.getCarWidth());

        shortDriver.setCarLoad(queryVo.getCarLoad());
        shortDriver.setCarVolume(queryVo.getCarVolume());

        shortDriver.setCarType(queryVo.getCarType());

        shortDriver.setStatus(1);

        shortDriverDao.save(shortDriver);

    }


    // 根据id 逻辑删除
    public void deleteById(String id) {
        shortDriverDao.updateStatus(0, id);
    }


    // 修改
    public void update(ShortDriverQueryVo queryVo) {

        Optional optional = shortDriverDao.findById(queryVo.getId());
        if(!optional.isPresent()){
            throw new RuntimeException(ResultMessage.SHORTDRIVER_NOT_FOUND);
        }
        ShortDriver shortDriver = (ShortDriver) optional.get();

        shortDriver.setName(queryVo.getName());
        shortDriver.setIdCard(queryVo.getIdCard());
        shortDriver.setPhone(queryVo.getPhone());
        shortDriver.setWeChat(queryVo.getWeChat());
        shortDriver.setCarNumber(queryVo.getCarNumber());
        shortDriver.setCarLength(queryVo.getCarLength());

        shortDriver.setCarHeight(queryVo.getCarHeight());

        shortDriver.setCarWidth(queryVo.getCarWidth());

        shortDriver.setCarLoad(queryVo.getCarLoad());
        shortDriver.setCarVolume(queryVo.getCarVolume());

        shortDriver.setCarType(queryVo.getCarType());

        shortDriver.setStatus(queryVo.getStatus());

        shortDriverDao.save(shortDriver);

    }


    // 根据 id 查询短驳车司机
    public ShortDriver findById(String id) {

        Optional optional = shortDriverDao.findById(id);

        if (!optional.isPresent()) {
            throw new RuntimeException(ResultMessage.SHORTDRIVER_NOT_FOUND);
        }

        return (ShortDriver) optional.get();

    }

    // 分页查询
    public Page<ShortDriver> paging(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by("name"));
        return shortDriverDao.findAll(pageRequest);
    }

    // 分页条件查询
    public Page<ShortDriver> search(ShortDriverQueryVo queryVo, int page, int size) {

        Specification<ShortDriver> specification = new Specification<ShortDriver>() {
            @Override
            public Predicate toPredicate(Root<ShortDriver> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicateList = new ArrayList<Predicate>();

                if (StringUtils.isNotEmpty(queryVo.getName())) {
                    predicateList.add(criteriaBuilder.like(root.get("name").as(String.class),
                            "%" + queryVo.getName() + "%"));
                }

                if (StringUtils.isNotEmpty(queryVo.getIdCard())) {
                    predicateList.add(criteriaBuilder.like(root.get("idCard").as(String.class),
                            "%" + queryVo.getIdCard() + "%"));
                }

                if (StringUtils.isNotEmpty(queryVo.getPhone())) {
                    predicateList.add(criteriaBuilder.like(root.get("phone").as(String.class),
                            "%" + queryVo.getPhone() + "%"));
                }

                if (StringUtils.isNotEmpty(queryVo.getCarNumber())) {
                    predicateList.add(criteriaBuilder.like(root.get("carNumber").as(String.class),
                            "%" + queryVo.getCarNumber() + "%"));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        PageRequest pageRequest = PageRequest.of(page - 1, size,Sort.by("name"));

        return shortDriverDao.findAll(specification,pageRequest);

    }



}
