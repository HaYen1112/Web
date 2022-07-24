package com.example.mypkg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_role")
public class UserAppRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "role_name")
	private String roleName;
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private UserApp user;
	@ManyToOne
	@JoinColumn(name = "role_name", insertable = false, updatable = false)
	private Role role;

	public UserAppRole(Long userId, String roleName) {
		super();
		this.userId = userId;
		this.roleName = roleName;
	}

}
