package com.cms.zl.security;

import com.cms.zl.entity.User;
import com.cms.zl.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vincent on 2016/12/23.
 */
@Component
public class BasedUserDetailsServiceImpl implements UserDetailsService {

    private final IUserRepository userRepository;

    @Autowired
    public BasedUserDetailsServiceImpl(IUserRepository iUserRepository) {
        this.userRepository = iUserRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("user not exists");
        }
        Set<GrantedAuthority> authoritySet = new HashSet<>();
        authoritySet.add(new SimpleGrantedAuthority("ROLE_USER"));
        if(user.getRole().equals("admin")) {
            //管理员拥有两种权限
            authoritySet.add(new SimpleGrantedAuthority("ROLE_USER"));
            authoritySet.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return new BasedUserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), authoritySet);
    }
}
