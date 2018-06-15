package com.dragonball.service.user.impl;

import com.dragonball.common.exception.BaseException;
import com.dragonball.common.exception.BusinessException;
import com.dragonball.common.model.GenericPage;
import com.dragonball.dao.user.db.UserDBDAO;
import com.dragonball.model.user.entity.UserEO;
import com.dragonball.service.user.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
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
        UserEO userEO = userDBDAO.getById(id);
        return userEO;
    }

    /**
     * 添加
     * @param num
     * @param userName
     */
    @Override
    public void save(int num,String userName) {
        if (StringUtils.isBlank(userName)){
            throw new BaseException("用户名不能为空");
        }
        UserEO userEO = new UserEO();
        userEO.setNum(num);
        userEO.setUserName(userName);
        userDBDAO.insert(userEO);
    }

    /**
     * 修改
     * @param id
     * @param num
     * @param userName
     */
    @Override
    public void update(Long id, int num,String userName) {
        if (id == null){
            throw new BusinessException("id为空");
        }
        if (StringUtils.isBlank(userName)){
            throw new BaseException("用户名不能为空");
        }
        UserEO userEO = userDBDAO.getById(id);
        if (userEO == null){
            return ;
        }
        userEO.setNum(num);
        userEO.setUserName(userName);
        userDBDAO.update(userEO);
    }

    /**
     * 根据主键删除
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
