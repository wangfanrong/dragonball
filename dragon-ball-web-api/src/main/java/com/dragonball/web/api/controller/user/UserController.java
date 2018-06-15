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
import java.util.List;
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
     * 用户查询
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectUser", method = RequestMethod.POST)
    public IServiceResponse selectUser(@RequestBody UserRequest request){
        UserResponse response = new UserResponse();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("num",request.getNum());
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
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public IServiceResponse addUser(@RequestBody UserRequest request){
        BaseResponse<UserResponse> response = new BaseResponse<UserResponse>();
        try {
            userService.save(request.getNum(),request.getUserName());
            this.success(response);
        }catch (BusinessException e){
            // 捕获未知异常
            this.error(response, e.getMessage());
            LogUtils.logError("添加用户发生异常:{}", e);
        }
        return response;
    }

    /**
     * 用户修改
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public IServiceResponse updateUser(@RequestBody UserRequest request){
        BaseResponse<UserResponse> response = new BaseResponse<UserResponse>();
        try {
            userService.update(request.getId(), request.getNum(),request.getUserName());
            this.success(response);
        }catch (BusinessException e){
            // 捕获未知异常
            this.error(response, e.getMessage());
            LogUtils.logError("修改用户发生异常:{}", e);
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
