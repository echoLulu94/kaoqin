package com.cxs.extension.ath.controller;

import com.cxs.extension.ath.entity.User;
import com.cxs.extension.ath.mapper.UserMapper;
import com.cxs.extension.ath.service.api.BasicService;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.framework.dto.ResultDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shylqian
 * @Description:
 * @Date: created on 上午11:48 18/3/6
 */
@RestController
@RequestMapping("basic")
public class BasicController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BasicService basicService;

    @RequestMapping("one")
    @NoAuth
    public Map<String,Object> login(){
        Map<String,Object> result = new HashMap<>();
        result.put("code","1");
        result.put("user",userMapper.findByEnName("wuhuimin"));
        return  result;
    }

    @RequestMapping("getBasic")
    @NoAuth
    @ResponseBody
    public  ResultDo<Map<String, Object>> GetBasic()  {
        return basicService.GetBasic();
    }



    @RequestMapping("three")
    @NoAuth
    public Map<String,Object> updatePhone(){
        Map<String,Object> result = new HashMap<>();
        User user = userMapper.findByEnName("wuhuimin");
        user.setPhone("123");
        userMapper.updateByPrimaryKey(user);
        result.put("code","1");
        return  result;
    }
}
