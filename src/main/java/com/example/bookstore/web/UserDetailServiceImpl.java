package com.example.bookstore.web;

import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  private final UserRepository repository;

  @Autowired
  public UserDetailServiceImpl(UserRepository userRepository) {
    this.repository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User current = repository.findByUsername(username);

    return new org.springframework.security.core.userdetails.User(
        username, current.getPassword(), AuthorityUtils.createAuthorityList(current.getRole()));
  }
}
