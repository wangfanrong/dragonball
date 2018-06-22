package com.dragonball.web.api.controller.user;

import com.dragonball.common.service.AbstractBaseService;
import com.dragonball.common.utils.LogUtils;
import com.dragonball.model.user.request.UserRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 汪先森 on 2018/6/21.
 * 用户登录
 */
@Controller
public class LoginController extends AbstractBaseService {

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @ResponseBody
    @RequestMapping(value = "login/toLogin", method = RequestMethod.POST)
    public Map<String, Object> toLogin(@RequestBody UserRequest request){
        Map<String, Object> map = new HashMap<>();
        UsernamePasswordToken token = new UsernamePasswordToken(request.getAccount(),request.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            map.put("success",200);
            map.put("info","登录成功");
        }catch (Exception e){
            // 捕获未知异常
            e.printStackTrace();
            map.put("success",false);
            map.put("info","账号或者密码错误!");
            LogUtils.logError("账号或者密码错误:{}", e);
        }
        return map;
    }


}
