package com.dragonball.service.user;

import com.dragonball.common.model.GenericPage;
import com.dragonball.model.user.entity.UserEO;

import java.util.List;
import java.util.Map;

/**
 * Created by 汪先森 on 2018/5/29.
 */
public interface IUserService {

    UserEO getById(Long id);

    void save(int num,String userName);

    void update(Long id, int num,String userName);

    int delete(Long id);

    List<UserEO> batchAdd(List<UserEO> list);

    List<UserEO> selectByMap(Map<String, Object> map);

    GenericPage<UserEO> selectByMap(Map<String, Object> queryParam, int pageSize, int startIndex, String orderBy, boolean isAsc);
}
