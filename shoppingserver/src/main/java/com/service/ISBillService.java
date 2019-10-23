package com.service;

import com.entity.*;

import java.util.*;

public interface ISBillService {

    List<SBill> selectAll(Map<String,Object> mp);

    Integer insert(SBill b);

    Integer deleteByPrimaryKey(Long id);

    SBill selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(SBill b);
}
