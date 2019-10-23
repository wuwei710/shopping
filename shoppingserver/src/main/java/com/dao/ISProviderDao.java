package com.dao;
import java.util.*;
import com.entity.*;

public interface ISProviderDao {

    List<SProvider> selectAllprovider(Map<String,Object> mp);

    SProvider selectByPrimaryKey(Long id);

    Integer deleteByPrimaryKey(Long id);

    Integer insert(SProvider sp);

    Integer updateByPrimaryKeySelective(SProvider sp);
}
