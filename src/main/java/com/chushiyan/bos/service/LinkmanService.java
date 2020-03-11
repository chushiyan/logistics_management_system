package com.chushiyan.bos.service;

import com.chushiyan.bos.dao.CustomerDao;
import com.chushiyan.bos.dao.LinkmanDao;
import com.chushiyan.bos.queryvo.LinkmanQueryVo;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.pojo.Customer;
import com.chushiyan.bos.pojo.Linkman;
import com.chushiyan.bos.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
@Service
@Transactional
public class LinkmanService {

    @Autowired
    private LinkmanDao linkmanDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private IdWorker idWorker;


    public void add(LinkmanQueryVo queryVo) {
        Linkman linkman = new Linkman();
        linkman.setId(String.valueOf(idWorker.nextId()));
        linkman.setName(queryVo.getName());
        linkman.setPhone(queryVo.getPhone());
        linkman.setPosition(queryVo.getPosition());
        linkman.setGender(queryVo.getGender());
        linkman.setMobile(queryVo.getMobile());
        linkman.setEmail(queryVo.getEmail());
        linkman.setMemo(queryVo.getMemo());
        linkman.setStatus(1);

        linkmanDao.save(linkman);
    }

    public void deleteById(String id) {
        linkmanDao.updateStatus(0, id);

    }

    public void update(LinkmanQueryVo queryVo) {
        Optional optional = linkmanDao.findById(queryVo.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException(ResultMessage.DATA_INVALID);
        }

        Linkman linkman = (Linkman) optional.get();

        linkman.setName(queryVo.getName());
        linkman.setGender(queryVo.getGender());
        linkman.setPhone(queryVo.getPhone());
        linkman.setMobile(queryVo.getMobile());
        linkman.setEmail(queryVo.getEmail());
        linkman.setPosition(queryVo.getPosition());
        linkman.setMemo(queryVo.getMemo());

        linkman.setStatus(queryVo.getStatus());

        if (StringUtils.isNotEmpty(queryVo.getCustomerId())) {
            Optional customerOptional = customerDao.findById(queryVo.getCustomerId());
            if (!customerOptional.isPresent()) {
                throw new RuntimeException(ResultMessage.CUSTOMER_NOT_FOUND);
            }
            Customer customer = (Customer) customerOptional.get();
            linkman.setCustomer(customer);
        }
        linkmanDao.save(linkman);
    }

    public Linkman findById(String id) {
        Optional optional = linkmanDao.findById(id);
        if(!optional.isPresent()){
            throw new RuntimeException(ResultMessage.LINKMAN_NOT_FOUND);
        }
        return (Linkman) optional.get();

    }

    public Page<Linkman> paging(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by("name").descending());
        return linkmanDao.findAll(pageRequest);
    }
}
