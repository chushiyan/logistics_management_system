package com.chushiyan.bos.service;

import com.chushiyan.bos.dao.TrailerDriverDao;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.pojo.TrailerDriver;
import com.chushiyan.bos.queryvo.ShortDriverQueryVo;
import com.chushiyan.bos.queryvo.TrailerDriverQueryVo;
import com.chushiyan.bos.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class TrailerDriverService {

    @Autowired
    private TrailerDriverDao trailerDriverDao;

    @Autowired
    private IdWorker idWorker;

    // 增加
    public void add(TrailerDriverQueryVo queryVo) {

        TrailerDriver driver = this.queryVoToEntity(new TrailerDriver(), queryVo);

        driver.setId(String.valueOf(idWorker.nextId()));

        driver.setStatus(1);

        trailerDriverDao.save(driver);

    }

    // 逻辑删除
    public void deleteById(String id) {
        trailerDriverDao.updateStatus(0, id);
    }

    // 修改
    public void update(TrailerDriverQueryVo queryVo) {
        Optional optional = trailerDriverDao.findById(queryVo.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException(ResultMessage.TRAILERDRIVER_NOT_FOUND);
        }
        TrailerDriver driver = this.queryVoToEntity((TrailerDriver) optional.get(), queryVo);

        trailerDriverDao.save(driver);

    }

    private TrailerDriver queryVoToEntity(TrailerDriver driver, TrailerDriverQueryVo queryVo) {

        driver.setName(queryVo.getName());

        driver.setIdCard(queryVo.getIdCard());

        driver.setPhone(queryVo.getPhone());

        driver.setWeChat(queryVo.getWeChat());

        driver.setCarNumber(queryVo.getCarNumber());

        driver.setCarHeight(queryVo.getCarHeight());

        driver.setCarLength(queryVo.getCarLength());

        driver.setCarWidth(queryVo.getCarWidth());

        driver.setCarLoad(queryVo.getCarLoad());

        driver.setCarVolume(queryVo.getCarVolume());

        driver.setStatus(queryVo.getStatus());

        return driver;

    }

    // 根据 id 查询挂车司机
    public TrailerDriver findById(String id) {
        Optional optional = trailerDriverDao.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException(ResultMessage.TRAILERDRIVER_NOT_FOUND);
        }
        return (TrailerDriver) optional.get();
    }


    // 分页查询
    public Page<TrailerDriver> paging(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by("name"));
        return trailerDriverDao.findAll(pageRequest);
    }


    // 分页条件查询
    public Page<TrailerDriver> search(int page, int size, TrailerDriverQueryVo queryVo) {
        Specification<TrailerDriver> specification = new Specification<TrailerDriver>() {
            @Override
            public Predicate toPredicate(Root<TrailerDriver> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<Predicate>();

                predicateList.add(criteriaBuilder.like(root.get("name").as(String.class),
                        "%" + queryVo.getName() + "%"));

                if (StringUtils.isNotEmpty(queryVo.getIdCard())) {
                    predicateList.add(criteriaBuilder.like(root.get("idCard").as(String.class),
                            "%" + queryVo.getIdCard() + "%"
                            )
                    );
                }

                if (StringUtils.isNotEmpty(queryVo.getPhone())) {
                    predicateList.add(criteriaBuilder.like(root.get("phone").as(String.class),
                            "%" + queryVo.getPhone() + "%"
                            )
                    );
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by("name"));
        return trailerDriverDao.findAll(specification, pageRequest);
    }
}
