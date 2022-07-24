package com.example.mypkg.service.imp;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mypkg.dto.RoleDTO;
import com.example.mypkg.entity.Role;
import com.example.mypkg.repository.RoleRepository;
import com.example.mypkg.service.RoleService;

@Service
@Transactional(rollbackOn = Exception.class)
public class RoleServiceImp implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean addRole(RoleDTO roleDTO) {
		try {
			roleRepository.save(modelMapper.map(roleDTO, Role.class));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
