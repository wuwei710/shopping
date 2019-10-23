package com.service.impl;
import java.util.*;
import com.entity.*;
import com.dao.*;
import com.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value = "sproviderService")
public class SProviderService implements ISProviderService{
    @Autowired
    private ISProviderDao spd;

    @Override
    public List<SProvider> selectAllprovider( Map<String, Object> mp){
        List<SProvider> list1 = spd.selectAllprovider(mp);
        return list1;
    }

    @Override
    public SProvider selectByPrimaryKey(Long id) {

        return spd.selectByPrimaryKey(id);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {

        return spd.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(SProvider sp) {

        return spd.insert(sp);
    }

    @Override
    public Integer updateByPrimaryKeySelective(SProvider sp) {

        return spd.updateByPrimaryKeySelective(sp);
    }
}
