package com.action;
import java.util.*;
import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@RestController
public class SBillController {
    @Autowired
    private ISBillService sbs;

    //  查询所有订单
     @RequestMapping(value = "/allbill",produces ={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SBill> allbill(@RequestParam Map<String,Object> mp) throws  Exception{
         System.out.println("服务端mp"+mp);
         System.out.println("我是第二个服务器，8910");
        Map rm = chuli(mp);
        System.out.println("服务端rm"+rm);
        List<SBill> list1 = sbs.selectAll(rm);
        if(list1.size() < 0){
            list1 = new ArrayList();
        }
        return list1;
    }
    //数据处理
    //数据处理
    private Map chuli(Map<String,Object> mp){
        Map rm = new HashMap();
        //处理商品名称数据
        if(mp.containsKey("productname")){
            String  productname = mp.get("productname").toString();
            if(!productname.trim().equals("")){
                rm.put("productname",productname);
            }
        }
        //处理供应商ID数据
        if(mp.containsKey("providerid")){
            String providerid = mp.get("providerid").toString();
            if(!providerid.trim().equals("")){
                rm.put("providerid",providerid);
            }
        }
        //处理付款数据
        if(mp.containsKey("ispayment")){
            String ispayment = mp.get("ispayment").toString();
            if(!ispayment.trim().equals("")){
                rm.put("ispayment",ispayment);
            }
        }
        return rm;
    }
   //新增订单
    @RequestMapping(value = "/addbill",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer addbill(@RequestBody SBill b)throws Exception{
         Integer num = sbs.insert(b);

         return num;
    }
    //按id查订单
    @RequestMapping(value ="/selectonebill/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SBill selectonebill(@PathVariable(value = "id") Long id)throws Exception{

        SBill sb = sbs.selectByPrimaryKey(id);
         return  sb;
    }
    //删除订单
    @RequestMapping(value = "/delbill/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer delbill(@PathVariable(value = "id") Long id)throws  Exception{

         Integer num = sbs.deleteByPrimaryKey(id);
            return num;
    }
    //修改订单信息
    @RequestMapping(value = "/updatebill",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer updatebill(@RequestBody SBill b)throws  Exception{

         Integer num = sbs.updateByPrimaryKeySelective(b);
         return  num;
    }
}
