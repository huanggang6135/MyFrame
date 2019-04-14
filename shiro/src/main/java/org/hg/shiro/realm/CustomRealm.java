package org.hg.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hg.shiro.dto.User;
import org.hg.shiro.service.UserService;
import org.hg.shiro.util.Encrypts;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author hg
 * @Date 2019/4/2 17:23
 * @Version 1.0
 **/
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*** ============ 权限认证  ================= **/
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRolesByUserName(username));
        authorizationInfo.setStringPermissions(userService.findPermissionsByUserName(username));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*** ============ 身份认证  ================= **/
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        String username = passwordToken.getUsername();
        String password = String.valueOf(passwordToken.getPassword());
        User byName = userService.findByName(username);
        if(byName == null || byName.getPassword()==null || !byName.getPassword().equals(Encrypts.passwordMd5(password, byName.getSalt()))){
            throw new AccountException("账号/密码不正确");
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
