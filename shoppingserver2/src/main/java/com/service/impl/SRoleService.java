package com.service.impl;

import com.dao.ISrole;
import com.entity.SRole;
import com.service.ISRoleService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value ="sroleService" )
public class SRoleService implements ISRoleService{
    @Autowired
    private ISrole  sd;
    @Override
    public List<SRole> selectAllsrole() {

        return sd.selectAllsrole();
    }
}
