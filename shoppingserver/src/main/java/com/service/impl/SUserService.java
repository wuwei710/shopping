package com.service.impl;
import java.util.*;
import com.entity.*;
import com.dao.*;
import com.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value ="suserService" )
public class SUserService implements ISUserService{

    @Autowired
    private ISUserDao sud;


    @Override
    public SUser selectlogin(Map<String,Object> mp) {

        return sud.selectlogin(mp);
    }

    @Override
    public Integer insert(SUser u) {

        return sud.insert(u);
    }

    @Override
    public SUser selectByPrimaryKey(Long id) {

        return sud.selectByPrimaryKey(id);
    }

    @Override
    public List<SUser> selectAlluser(Map<String, Object> mp) {

        return sud.selectAlluser(mp);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {

        return sud.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(SUser u) {

        return sud.updateByPrimaryKeySelective(u);
    }
}
