package com.service.impl;
import java.util.*;
import com.entity.*;
import com.dao.*;
import com.service.ISBillService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value ="sbillService" )
public class SBillService implements ISBillService{
    @Autowired
    private ISBillDao sbd;


    @Override
    public List<SBill> selectAll(Map<String, Object> mp) {
        List<SBill> list1 = sbd.selectAll(mp);

        return list1;
    }

    @Override
    public Integer insert(SBill b) {
        Integer num = sbd.insert(b);

        return num;
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {

        return sbd.deleteByPrimaryKey(id);
    }

    @Override
    public SBill selectByPrimaryKey(Long id) {

        return sbd.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(SBill b) {

        return sbd.updateByPrimaryKeySelective(b);
    }
}
