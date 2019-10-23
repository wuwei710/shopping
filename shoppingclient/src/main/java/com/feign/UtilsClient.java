package com.feign;
import java.util.*;
import com.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "shoppingsever",fallback = FallBackClient.class)
public interface UtilsClient {

    //登陆的方法
    @RequestMapping(value ="/login",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SUser login(@RequestParam Map<String,Object> mp) throws Exception;

    // 注册的方法
    @RequestMapping(value ="/adduser",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer adduser(SUser u) throws  Exception;

    //按id查询用户
    @RequestMapping(value ="/oneuser/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SUser oneuser(@PathVariable(value = "id") Long id ) throws  Exception;
    //查所有用户
    @RequestMapping(value ="/alluser",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SUser> alluser(@RequestParam Map<String,Object> mp)throws Exception;

    //删除用户
    @RequestMapping(value ="/deluser/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  deluser(@PathVariable(value = "id") Long id)throws Exception;

    //修改用户
    @RequestMapping(value ="/updateuser",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  updateuser( SUser u)throws Exception;

    //所有职位
    @RequestMapping(value ="/allrole",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SRole>  allrole()throws Exception;



     //____________________________________________________________________________________
    //查所有订单
    @RequestMapping(value = "/allbill",produces ={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SBill> allbill(@RequestParam Map<String,Object> mp) throws Exception;

    //新增订单
    @RequestMapping(value = "/addbill",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer addbill( SBill b)throws Exception;

    //按id查订单
    @RequestMapping(value ="/selectonebill/{id}",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SBill selectonebill(@PathVariable(value = "id") Long id)throws Exception;

    //删除订单
    @RequestMapping(value = "/delbill/{id}",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer delbill(@PathVariable(value = "id") Long id)throws  Exception;

    //修改订单信息
    @RequestMapping(value = "/updatebill",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer updatebill( SBill b)throws  Exception;

}
