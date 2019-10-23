package com.feign;

import com.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient(value = "shoppingsever",fallback = FallBackClient2.class)
public interface UtilsClient2 {

    // 查所有
    @RequestMapping(value = "/selectAllprovider",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SProvider> selectAllprovider(@RequestParam Map<String,Object> mp)throws Exception;
   //新增
    @RequestMapping(value = "/addsprovider",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  addsprovider(SProvider sp) throws Exception;
    //按id 查
    @RequestMapping(value = "/onesprovider/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public SProvider onesprovider(@PathVariable(value = "id") Long id)throws  Exception;
    //删除
    @RequestMapping(value = "/delsprovider/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer delsprovider(@PathVariable(value = "id") Long id) throws Exception;
    // 修改
    @RequestMapping(value = "/upsprovider",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  upsprovider(SProvider sp) throws  Exception;

}
