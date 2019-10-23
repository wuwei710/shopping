package com.action;

import com.entity.SRole;
import com.entity.SUser;
import com.feign.UtilsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
public class IndexUserController {

    @Autowired
    private UtilsClient uc;

    //登陆
    @RequestMapping(value ="/login",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SUser login(@RequestParam Map<String,Object> mp, HttpSession session) throws Exception{
         SUser u1 = uc.login(mp);
         session.setAttribute("userinfo",u1);
         if(u1==null){
             u1=new SUser();
         }
        return u1;
    }

    // 注册的方法
    @RequestMapping(value ="/adduser",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer adduser(SUser u) throws  Exception{

        return uc.adduser(u);
    }

    //按id查询
    @RequestMapping(value ="/oneuser/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SUser oneuser(@PathVariable(value = "id") Long id ) throws  Exception{

        return uc.oneuser(id);
    }
    // 用户处理
    @RequestMapping(value ="/names",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SUser names(HttpSession session) throws Exception{
       SUser uu = (SUser)session.getAttribute("userinfo");
       if(uu==null){
           uu = new SUser();
       }
        return uu;
    }

    //查所有用户
    @RequestMapping(value ="/alluser",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SUser> alluser(@RequestParam Map<String,Object> mp)throws Exception{
        List<SUser>  list = uc.alluser(mp);
        if(list.size()<0){
            list = new ArrayList();
        }
        return list;
    }

    //删除用户
    @RequestMapping(value ="/deluser/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  deluser(@PathVariable(value = "id") Long id)throws Exception{
        Integer num = uc.deluser(id);
       return num;
    }

    //修改用户
    @RequestMapping(value ="/updateuser",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  updateuser( SUser u)throws Exception{

        Integer num = uc.updateuser(u);
        return num;
    }
    //所有职位
    @RequestMapping(value ="/allrole",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SRole>  allrole()throws Exception{
        List<SRole>  list1 = uc.allrole();
        if(list1.size()<0){
            list1 = new ArrayList();
        }
        return list1;
    }
    //修改密码
    @RequestMapping(value = "/updatepwd",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Boolean updatepwd(@RequestParam Map<String,Object>mp,HttpSession session)throws Exception{
        Boolean ck = true;
        SUser u1 = (SUser) session.getAttribute("userinfo");
        if(u1.getUserpassword().equals(mp.get("password1").toString())){
            SUser u2 = new SUser();
            u2.setId(u1.getId());
            u2.setUserpassword(mp.get("password2").toString());
             Integer num = uc.updateuser(u2);
             if(num<0){
                 ck=false;
             }
        }else {
            ck=false;
        }

        return ck;
    }

}
