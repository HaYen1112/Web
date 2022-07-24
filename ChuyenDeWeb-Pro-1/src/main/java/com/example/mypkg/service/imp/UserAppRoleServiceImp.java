package com.example.mypkg.service.imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mypkg.entity.UserAppRole;
import com.example.mypkg.repository.UserAppRoleRepository;
import com.example.mypkg.service.UserAppRoleService;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserAppRoleServiceImp implements UserAppRoleService {
	@Autowired
	private UserAppRoleRepository userAppRoleRepository;

	@Override
	public boolean addRoleToUser(Long userAppId, String roleName) {
		try {
			userAppRoleRepository.save(new UserAppRole(userAppId, roleName));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
