package com.team3.app.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.team3.app.entities.Role;
import com.team3.app.entities.User;
import com.team3.app.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    Set<GrantedAuthority> grantedAuthorities = new HashSet();
    Set<Role> roles = user.getRoles();
    for (Role role : roles) {
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    }

    return new org.springframework.security.core.userdetails.User(user.getEmail(),
        user.getPassword(), grantedAuthorities);
  }

}
