package com.example.mypkg.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mypkg.entity.UserApp;
import com.example.mypkg.repository.RoleRepository;
import com.example.mypkg.repository.UserAppRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	@Autowired
	private UserAppRepository userAppRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserApp appUser = userAppRepository.findByEmail(userName).get();

		if (appUser == null) {
			System.out.println("User not found! " + userName);
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");
		}

		List<String> roleNames = roleRepository.getRoleNamesByUserAppId(appUser.getId());

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleNames != null) {
			for (String role : roleNames) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}

		UserDetails userDetails = (UserDetails) new User(appUser.getEmail(), //
				appUser.getPassword(), grantList);

		return userDetails;
	}
}
