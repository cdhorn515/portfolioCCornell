package com.cdhorn.Services;


import com.cdhorn.Models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    User findByUsername (String username);
}
