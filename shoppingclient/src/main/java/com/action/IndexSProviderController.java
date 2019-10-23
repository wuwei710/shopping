package com.action;
import java.util.*;
import com.entity.*;

import com.feign.UtilsClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
public class IndexSProviderController {

    @Autowired
    private UtilsClient2  uc2;

    @RequestMapping(value = "/selectAllprovider",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SProvider> selectAllprovider(@RequestParam Map<String,Object> mp)throws Exception{

        List<SProvider> list3 = uc2.selectAllprovider(mp);
        if(list3==null){
            list3 = new ArrayList();
        }
        return list3;
    }

    //新增
    @RequestMapping(value = "/addsprovider",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  addsprovider(SProvider sp, HttpSession session) throws Exception{
        SUser uu = (SUser) session.getAttribute("userinfo");
        sp.setCreatedby(uu.getId());
        Integer num =uc2.addsprovider(sp);
        return num;

    }
    //按id 查
    @RequestMapping(value = "/onesprovider/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SProvider onesprovider(@PathVariable(value = "id") Long id)throws  Exception{
        SProvider sp = uc2.onesprovider(id);
        return sp;
    }
    //删除
    @RequestMapping(value = "/delsprovider/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer delsprovider(@PathVariable(value = "id") Long id) throws Exception{
        Integer num = uc2.delsprovider(id);
            return num;
    }
    // 修改
    @RequestMapping(value = "/upsprovider",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  upsprovider(SProvider sp,HttpSession session) throws  Exception{
        System.out.println("供应商是："+sp);
        SUser uu = (SUser) session.getAttribute("userinfo");
        sp.setModifyby(uu.getId());
        System.out.println("222供应商产品是："+sp);
        Integer num = uc2.upsprovider(sp);
        return  num ;
    }
}
