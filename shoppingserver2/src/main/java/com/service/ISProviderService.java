package com.service;

import com.entity.*;

import java.util.*;

public interface ISProviderService {

    List<SProvider> selectAllprovider(Map<String, Object> mp);

    SProvider selectByPrimaryKey(Long id);

    Integer deleteByPrimaryKey(Long id);

    Integer insert(SProvider sp);

    Integer updateByPrimaryKeySelective(SProvider sp);
}
