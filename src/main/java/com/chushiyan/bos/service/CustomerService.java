package com.chushiyan.bos.service;

import com.chushiyan.bos.dao.CustomerDao;
import com.chushiyan.bos.queryvo.CustomerQueryVo;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.pojo.Customer;
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
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private IdWorker idWorker;


    public void add(CustomerQueryVo customerQueryVo) {

        Customer customer = new Customer();
        customer.setId(String.valueOf(idWorker.nextId()));
        customer.setName(customerQueryVo.getName());
        customer.setFullName(customerQueryVo.getFullName());
        customer.setAddress(customerQueryVo.getAddress());
        customer.setStatus(1);
        customerDao.save(customer);

    }

    public void deleteById(String id) {
        customerDao.updateStatus(0, id);
    }

    public void update(CustomerQueryVo queryVo) {

        Optional optional = customerDao.findById(queryVo.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException(ResultMessage.CUSTOMER_NOT_FOUND);
        }

        Customer customer = (Customer) optional.get();

        customer.setName(queryVo.getName());

        customer.setFullName(queryVo.getFullName());

        customer.setAddress(queryVo.getAddress());

        customer.setStatus(queryVo.getStatus());

        customerDao.save(customer);
    }

    public Customer findById(String id) {

        Optional  optional = customerDao.findById(id);

        if(!optional.isPresent()){
            throw new RuntimeException(ResultMessage.CUSTOMER_NOT_FOUND);
        }

        return (Customer) optional.get();
    }

    public Page<Customer> paging(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by("name").descending());
        return customerDao.findAll(pageRequest);
    }
}
