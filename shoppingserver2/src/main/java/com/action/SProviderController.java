package com.action;
import java.util.*;
import com.dao.*;
import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@RestController
public class SProviderController {
    @Autowired
    private ISProviderService sps;

    //查询所有、按条件查询
    @RequestMapping(value = "/selectAllprovider",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SProvider> selectAllprovider(@RequestParam Map<String,Object> mp)throws Exception{
        //先对数据进行处理
        Map rm = chuli(mp);
        List<SProvider> list2 = sps.selectAllprovider(rm);
        if(list2==null){
            // 如果未查出 则返回空集合
            list2=new ArrayList();
        }
        return list2;
    }
   //数据处理
    private Map chuli(Map<String,Object> mp){
        Map rm = new HashMap();
        //处理编号数据
        if(mp.containsKey("procode")){
            String  procode = mp.get("procode").toString();
            if(!procode.trim().equals("")){
                rm.put("procode",procode);
            }
        }
        //处理名称数据
        if(mp.containsKey("proname")){
            String proname = mp.get("proname").toString();
            if(!proname.trim().equals("")){
                rm.put("proname",proname);
            }
        }
        return rm;
    }

    // 新增
    @RequestMapping(value = "/addsprovider",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  addsprovider(@RequestBody SProvider sp) throws  Exception{

        Integer num = sps.insert(sp);
        return num;
    }
    //按id 查
    @RequestMapping(value = "/onesprovider/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SProvider onesprovider(@PathVariable(value = "id") Long id)throws  Exception{
        SProvider sp = sps.selectByPrimaryKey(id);
        return sp;
    }
    //删除
    @RequestMapping(value = "/delsprovider/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer delsprovider(@PathVariable(value = "id") Long id) throws Exception{
        Integer num = sps.deleteByPrimaryKey(id);
        return num;
    }

    // 修改
    @RequestMapping(value = "/upsprovider",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  upsprovider(@RequestBody SProvider sp) throws  Exception{

        Integer num = sps.updateByPrimaryKeySelective(sp);
        return num;
    }
}
