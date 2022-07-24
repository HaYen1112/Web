package com.example.mypkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mypkg.entity.UserAppRole;

@Repository
public interface UserAppRoleRepository extends JpaRepository<UserAppRole, Long> {

}
