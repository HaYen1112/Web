package com.example.mypkg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mypkg.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	@Query("SELECT r.roleName FROM Role r JOIN UserAppRole u on r.roleName = u.roleName where u.userId = :userAppId")
	public List<String> getRoleNamesByUserAppId(@Param("userAppId") Long userAppId);
}
