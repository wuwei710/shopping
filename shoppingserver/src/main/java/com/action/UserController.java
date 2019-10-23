package com.action;

import java.util.*;

import com.service.*;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@CrossOrigin(allowCredentials ="true",maxAge = 3600)
@RestController
public class UserController {


    @Autowired
    private ISUserService sus;
    @Autowired
    private ISRoleService srs;
   //登陆的方法
   @RequestMapping(value ="/login",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SUser login(@RequestParam Map<String,Object> mp) throws Exception{
       System.out.println("对象"+mp);
        SUser u1 = sus.selectlogin(mp);
        if(u1==null){
            u1=new SUser();
        }
        return u1;
    }

    // 注册的方法
    @RequestMapping(value ="/adduser",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer adduser(@RequestBody SUser u) throws  Exception{
             Integer num = sus.insert(u);
        return num;

    }
    //按id查询
    @RequestMapping(value ="/oneuser/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SUser oneuser(@PathVariable(value = "id") Long id ) throws  Exception{
       SUser u1 = sus.selectByPrimaryKey(id);
        return u1;

    }
    //查所有用户
    @RequestMapping(value ="/alluser",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SUser> alluser(@RequestParam Map<String,Object> mp)throws Exception{
       Map rm =chuli1(mp);
       List<SUser> list = sus.selectAlluser(rm);
       return list;

    }
    //数据处理
    private Map chuli1(Map<String,Object> mp){
        Map rm =new  HashMap();
        if(mp.containsKey("username")){
            String username = mp.get("username").toString();
            if(!username.trim().equals("")){
                rm.put("username",username);
            }
        }

        if(mp.containsKey("roleid")){
            String roleid1= mp.get("roleid").toString();
            if(!roleid1.trim().equals("")){
                Long roleid = Long.valueOf(roleid1);
                if(roleid>0){
                    rm.put("roleid",roleid);
                }
            }

        }
        return  rm;
    }
    //删除用户
    @RequestMapping(value ="/deluser/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  deluser(@PathVariable(value = "id") Long id)throws Exception{

        Integer num = sus.deleteByPrimaryKey(id);

        return  num;
    }

    //修改用户
    @RequestMapping(value ="/updateuser",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  updateuser(@RequestBody SUser u)throws Exception{
        Integer num = sus.updateByPrimaryKeySelective(u);

        return num;
    }

    //所有职位
    @RequestMapping(value ="/allrole",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SRole>  allrole()throws Exception{
        List<SRole> list = srs.selectAllsrole();

        return list;
    }


}
