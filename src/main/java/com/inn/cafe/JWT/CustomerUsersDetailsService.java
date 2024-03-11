package com.inn.cafe.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inn.cafe.doa.UserDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerUsersDetailsService implements UserDetailsService{
	
	@Autowired
	UserDao userDao;
	
	Logger log = LoggerFactory.getLogger(CustomerUsersDetailsService.class);
	
	private com.inn.cafe.POJO.User userDetail;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Inside loadUserByUsername {}",username);
		userDetail = userDao.findByEmailId(username);
		if (!Objects.isNull(userDetail)) {
			return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
	}
	
	public com.inn.cafe.POJO.User getUserDetails() {
		return userDetail;
	}
	
	
}
