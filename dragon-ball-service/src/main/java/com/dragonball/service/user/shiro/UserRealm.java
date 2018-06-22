package com.dragonball.service.user.shiro;

import com.dragonball.dao.user.db.UserDBDAO;
import com.dragonball.model.user.entity.UserEO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 汪先森 on 2018/6/21.
 * 用户认证授权
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private UserDBDAO userDBDAO;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        String account = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        UserEO userEO = userDBDAO.getUserByAccount(account);
        if (userEO == null){
            userEO = userDBDAO.getUserByPhone(account);
        }
        //账号不存在
        if (userEO == null){
            throw new UnknownAccountException("账号密码不正确");
        }

        //密码错误
        if (!password.equals(userEO.getPassword())){
            throw new IncorrectCredentialsException("账号密码不正确");
        }

        //账号锁定
        if (!userEO.getIsEnable()){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userEO, password, getName());
        return info;
    }

}
