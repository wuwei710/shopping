package com.action;
import java.util.*;
import com.entity.*;
import com.feign.UtilsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
public class IndexBillController {

    @Autowired
    private UtilsClient uc;

    //查询所有订单
    @RequestMapping(value = "/allbill",produces ={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SBill> allbill(@RequestParam Map<String,Object> mp) throws Exception{
        System.out.println("客户端的Mp"+mp);
        List<SBill>  list1 = uc.allbill(mp);


        return list1;

    }
    //新增订单
    @RequestMapping(value = "/addbill",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer addbill(SBill b, HttpSession session)throws Exception{
       SUser uu = (SUser) session.getAttribute("userinfo");
       b.setCreatedby(uu.getId());

        Integer num = uc.addbill(b);

        return num;
    }

    //按id查订单
    @RequestMapping(value ="/selectonebill/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SBill selectonebill(@PathVariable(value = "id") Long id)throws Exception{
        SBill sb = uc.selectonebill(id);
        if(sb==null){
            sb= new SBill();
        }
            return sb;
    }

    //删除订单
    @RequestMapping(value = "/delbill/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer delbill(@PathVariable(value = "id") Long id)throws  Exception{

        Integer num = uc.delbill(id);
        return  num ;
    }

    //修改订单信息
    @RequestMapping(value = "/updatebill",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer updatebill( SBill b,HttpSession session)throws  Exception{
        System.out.println("产品是："+b);
        SUser uu = (SUser) session.getAttribute("userinfo");
        b.setModifyby(uu.getId());
        System.out.println("222产品是："+b);
           Integer num = uc.updatebill(b);

           return num;
    }
}
