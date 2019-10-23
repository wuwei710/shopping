package com.dao;
import java.util.*;
import com.entity.*;

public interface ISUserDao {

    SUser selectlogin(Map<String,Object> mp);

    Integer insert(SUser u);

    SUser selectByPrimaryKey(Long id);

    List<SUser> selectAlluser(Map<String,Object> mp);

    Integer deleteByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(SUser u);


}
