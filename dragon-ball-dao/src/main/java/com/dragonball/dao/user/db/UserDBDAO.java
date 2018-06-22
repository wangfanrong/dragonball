package com.dragonball.dao.user.db;

import com.dragonball.common.model.GenericPage;
import com.dragonball.model.user.entity.UserEO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by 汪先森 on 2018/5/30.
 */
@Mapper
public interface UserDBDAO {

    UserEO getById(Long id);

    int insert(UserEO userEO);

    int update(UserEO userEO);

    int delete(Long id);

    List<UserEO> batchUpdate(List<UserEO> userEOList);

    List<UserEO> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> queryParam);

    GenericPage<UserEO> genericPageByMap(Map<String, Object> queryParam);

    UserEO getUserByAccount(String account);

    UserEO getUserByPhone(String phoneNumber);
}
