package com.msww.ms.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.msww.ms.user.model.SysUser;

public interface UserRepository extends CrudRepository<SysUser, String> {
    SysUser findByUserNameAndPassword(String userName, String password);

    SysUser findByUserName(String userName);

}
