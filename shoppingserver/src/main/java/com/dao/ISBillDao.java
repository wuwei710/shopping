package com.dao;
import java.util.*;
import com.entity.*;

public interface ISBillDao {

    List<SBill> selectAll(Map<String,Object> mp);

    Integer insert(SBill b);

    Integer deleteByPrimaryKey(Long id);

    SBill selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(SBill b);
}
