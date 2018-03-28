package com.msww.ms.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.msww.ms.user.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, String> {
}
