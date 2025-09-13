package cn.zero.mall.marketbackend.service;

import cn.zero.mall.marketbackend.entity.Admin;
import cn.zero.mall.marketbackend.mapper.AuthorizeMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Zero02
 */
@Service
public class AuthorizeService implements UserDetailsService {

    @Resource
    public AuthorizeMapper authorizeMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null) {
            throw new UsernameNotFoundException("用户名不能为空");
        }
        Admin admin = authorizeMapper.findAdmin(username);
        if (admin == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return User.withUsername(username).password(admin.getPassword()).roles("USER").build();
    }
}
