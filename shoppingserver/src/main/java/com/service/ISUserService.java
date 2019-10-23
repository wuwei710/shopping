package com.service;
import java.util.*;
import com.entity.*;
import com.dao.*;

public interface ISUserService {


    SUser selectlogin(Map<String,Object> mp);

    Integer insert(SUser u);

    SUser selectByPrimaryKey(Long id);

    List<SUser> selectAlluser(Map<String,Object> mp);

    Integer deleteByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(SUser u);

}
