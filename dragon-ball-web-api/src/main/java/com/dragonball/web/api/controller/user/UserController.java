package com.dragonball.web.api.controller.user;

import com.dragonball.common.context.response.BaseResponse;
import com.dragonball.common.context.response.GenericPageResponse;
import com.dragonball.common.context.response.IServiceResponse;
import com.dragonball.common.exception.BusinessException;
import com.dragonball.common.model.GenericPage;
import com.dragonball.common.service.AbstractBaseService;
import com.dragonball.common.utils.LogUtils;
import com.dragonball.model.user.entity.UserEO;
import com.dragonball.model.user.request.UserRequest;
import com.dragonball.model.user.response.UserResponse;
import com.dragonball.service.user.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 汪先森 on 2018/6/1.
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractBaseService{

    @Autowired
    private IUserService userService;

    /**
     * 根据条件查询
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectUser", method = RequestMethod.POST)
    public IServiceResponse selectUser(@RequestBody UserRequest request){
        UserResponse response = new UserResponse();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            if (StringUtils.isNotBlank(request.getUserName())){
                map.put("userName",request.getUserName());
            }
            if (StringUtils.isNotBlank(request.getNickName())){
                map.put("nickName",request.getNickName());
            }
            if (request.getSex() != null){
                map.put("sex",request.getSex());
            }
            if (StringUtils.isNotBlank(request.getAccount())){
                map.put("account",request.getAccount());
            }
            if (StringUtils.isNotBlank(request.getQQ())){
                map.put("QQ",request.getQQ());
            }
            if (StringUtils.isNotBlank(request.getWeiXin())){
                map.put("weiXin",request.getWeiXin());
            }
            if (StringUtils.isNotBlank(request.getEmail())){
                map.put("email",request.getEmail());
            }
            if (StringUtils.isNotBlank(request.getPhoneNumber())){
                map.put("phoneNumber",request.getPhoneNumber());
            }
            if (request.getIsEnable() != null){
                map.put("isEnable",request.getIsEnable());
            }
            if (request.getMemberType() != null){
                map.put("memberType",request.getMemberType());
            }

//            List<UserEO> userEOList = userService.selectByMap(map);
            int pageNum = request.getPageNum() != null ? request.getPageNum() : 0;
            int pageSize = request.getPageSize() != null ? request.getPageSize() : 0;
            int pageIndex = (pageNum-1) * pageSize;

            GenericPage<UserEO> genericPage = userService.selectByMap(map,pageSize,pageIndex,"id",true);
            response.setData(genericPage.getData());
            response.setPage(new GenericPageResponse(genericPage));
            this.success(response);
        }catch (BusinessException e){
            // 捕获未知异常
            this.error(response, e.getMessage());
            LogUtils.logError("查询用户发生异常:{}", e);
        }
        return response;
    }

    /**
     * 用户添加
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public IServiceResponse register(@RequestBody UserRequest request){
        BaseResponse<UserResponse> response = new BaseResponse<UserResponse>();
        try {
            UserEO userEO = new UserEO();
            userEO.setUserName(request.getUserName());
            userEO.setNickName(request.getNickName());
            userEO.setSex(request.getSex());
            userEO.setAccount(request.getAccount());
            userEO.setPassword(request.getPassword());
            userEO.setEmail(request.getEmail());
            userEO.setPhoneNumber(request.getPhoneNumber());
            if (StringUtils.isNotBlank(request.getHeadPhoto())){
                userEO.setHeadPhoto(request.getHeadPhoto());
            }
            if (StringUtils.isNotBlank(request.getSignature())){
                userEO.setSignature(request.getSignature());
            }
            if (StringUtils.isNotBlank(request.getQQ())){
                userEO.setQQ(request.getQQ());
            }
            if (StringUtils.isNotBlank(request.getWeiXin())){
                userEO.setWeiXin(request.getWeiXin());
            }
            userService.register(userEO);
            this.success(response);
        }catch (BusinessException e){
            // 捕获未知异常
            this.error(response, e.getMessage());
            LogUtils.logError("添加用户发生异常:{}", e);
        }
        return response;
    }

    /**
     * 用户编辑
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "editor", method = RequestMethod.POST)
    public IServiceResponse editor(@RequestBody UserRequest request){
        BaseResponse<UserResponse> response = new BaseResponse<UserResponse>();
        try {
            UserEO userEO = new UserEO();
            userEO.setId(request.getId());
            userEO.setUserName(request.getUserName());
            userEO.setNickName(request.getNickName());
            userEO.setSex(request.getSex());
            userEO.setAccount(request.getAccount());
            userEO.setPassword(request.getPassword());
            userEO.setEmail(request.getEmail());
            userEO.setPhoneNumber(request.getPhoneNumber());
            if (StringUtils.isNotBlank(request.getHeadPhoto())){
                userEO.setHeadPhoto(request.getHeadPhoto());
            }
            if (StringUtils.isNotBlank(request.getSignature())){
                userEO.setSignature(request.getSignature());
            }
            if (StringUtils.isNotBlank(request.getQQ())){
                userEO.setQQ(request.getQQ());
            }
            if (StringUtils.isNotBlank(request.getWeiXin())){
                userEO.setWeiXin(request.getWeiXin());
            }
            userService.editor(userEO);
            this.success(response);
        }catch (BusinessException e){
            // 捕获未知异常
            this.error(response, e.getMessage());
            LogUtils.logError("编辑用户发生异常:{}", e);
        }
        return response;
    }

    /**
     * 用户删除
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
    public IServiceResponse deleteUser(@RequestBody UserRequest request){
        BaseResponse<UserResponse> response = new BaseResponse<UserResponse>();
        try {
            userService.delete(request.getId());
            this.success(response);
        }catch (BusinessException e){
            // 捕获未知异常
            this.error(response, e.getMessage());
            LogUtils.logError("删除用户发生异常:{}", e);
        }
        return response;
    }



}
