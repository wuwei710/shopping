package com.feign;
import java.util.*;
import com.entity.*;
import org.springframework.stereotype.Component;

@Component
public class FallBackClient implements UtilsClient {

    @Override
    public SUser login(Map<String, Object> mp) throws Exception {

        return new SUser();
    }

    @Override
    public Integer adduser(SUser u) throws Exception {

        return 0;
    }

    @Override
    public SUser oneuser(Long id) throws Exception {
        return new SUser();
    }

    @Override
    public List<SBill> allbill(Map<String, Object> mp) throws Exception {

        return new ArrayList();
    }

    @Override
    public Integer addbill(SBill b) throws Exception {

        return 0;
    }

    @Override
    public SBill selectonebill(Long id) throws Exception {

        return new SBill();
    }

    @Override
    public Integer delbill(Long id) throws Exception {

        return 0;
    }

    @Override
    public Integer updatebill(SBill b) throws Exception {

        return 0;
    }

    @Override
    public List<SUser> alluser(Map<String, Object> mp) throws Exception {

        return new ArrayList();
    }

    @Override
    public Integer deluser(Long id) throws Exception {

        return 0;
    }

    @Override
    public Integer updateuser(SUser u) throws Exception {

        return 0;
    }

    @Override
    public List<SRole> allrole() throws Exception {

        return new ArrayList();
    }
}
