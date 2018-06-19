package com.dragonball.service.user.impl;

import com.dragonball.common.exception.BusinessException;
import com.dragonball.common.model.GenericPage;
import com.dragonball.dao.user.db.UserDBDAO;
import com.dragonball.model.user.entity.UserEO;
import com.dragonball.model.user.enums.MemberType;
import com.dragonball.service.user.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 汪先森 on 2018/3/21.
 * 用户
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDBDAO userDBDAO;

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @Override
    public UserEO getById(Long id) {
        if (id == null){
            throw new BusinessException("id为空");
        }
        return userDBDAO.getById(id);
    }

    /**
     * 注册新用户
     * @param userEO 用户信息
     */
    @Override
    public void register(UserEO userEO) {

        if (StringUtils.isBlank(userEO.getUserName())){
            throw new BusinessException("真实姓名为空");
        }
        if (StringUtils.isBlank(userEO.getNickName())){
            throw new BusinessException("昵称为空");
        }
        if (userEO.getSex() == null){
            throw new BusinessException("性别为空");
        }
        if (StringUtils.isBlank(userEO.getAccount())){
            throw new BusinessException("用户账号为空");
        }
        if (StringUtils.isBlank(userEO.getPassword())){
            throw new BusinessException("用户密码为空");
        }
        if (StringUtils.isBlank(userEO.getEmail())){
            throw new BusinessException("邮箱为空");
        }
        if (StringUtils.isBlank(userEO.getPhoneNumber())){
            throw new BusinessException("手机号码为空");
        }
        userEO.setIsEnable(Boolean.TRUE);
        userEO.setMemberType(MemberType.REGULAR_MEMBER.getCode());
        userDBDAO.insert(userEO);
    }

    /**
     * 编辑用户信息
     * @param userEO 用户信息
     */
    @Override
    public void editor(UserEO userEO){

        if (userEO == null){
            throw new BusinessException("用户信息为空");
        }
        UserEO newUser =  userDBDAO.getById(userEO.getId());
        if (newUser == null){
            throw new BusinessException("未找到该用户信息");
        }
        userDBDAO.update(userEO);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int delete(Long id) {
        if (id == null){
            throw new BusinessException("id为空");
        }
        return userDBDAO.delete(id);
    }

    /**
     * 批量新增
     * @param list
     * @return
     */
    @Override
    public List<UserEO> batchAdd(List<UserEO> list) {
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        for (UserEO userEO : list){
           userDBDAO.insert(userEO);
        }
         return list;
    }

    /**
     * 根据条件查询
     * @param map
     * @return
     */
    @Override
    public List<UserEO> selectByMap(Map<String, Object> map) {
        return userDBDAO.selectByMap(map);
    }

    /**
     * 分页查询
     * @param queryParam
     * @param pageSize
     * @param startIndex
     * @param orderBy
     * @param isAsc
     * @return
     */
    @Override
    public GenericPage<UserEO> selectByMap(Map<String, Object> queryParam, int pageSize, int startIndex, String orderBy, boolean isAsc) {

        if(queryParam == null){
            queryParam = new HashMap<String, Object>();
        }
        queryParam.put("ORDERBY", orderBy);
        if(isAsc){
            queryParam.put("ORDER", "ASC");
        }else{
            queryParam.put("ORDER", "DESC");
        }

        int totalSize = userDBDAO.countByMap(queryParam);
        if(totalSize == 0){
            return new GenericPage<UserEO>(startIndex, totalSize, pageSize, null);
        }
        queryParam.put("start",startIndex);
        queryParam.put("limit",pageSize);
        List<UserEO> pagedData = userDBDAO.selectByMap(queryParam);
        return new GenericPage<UserEO>(startIndex, totalSize, pageSize, pagedData);

    }


}
