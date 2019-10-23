package com.feign;

import java.util.*;
import com.entity.*;


import org.springframework.stereotype.Component;

@Component
public class FallBackClient2 implements UtilsClient2{

    @Override
    public List<SProvider> selectAllprovider(Map<String, Object> mp) throws Exception {

        return new ArrayList();
    }

    @Override
    public Integer addsprovider(SProvider sp) throws Exception {

        return 0;
    }

    @Override
    public SProvider onesprovider(Long id) throws Exception {

        return new SProvider();
    }

    @Override
    public Integer delsprovider(Long id) throws Exception {

        return 0;
    }

    @Override
    public Integer upsprovider(SProvider sp) throws Exception {

        return 0;
    }
}
