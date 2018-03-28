package com.msww.ms.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msww.ms.user.model.UserRole;
import com.msww.ms.user.repository.UserRoleRepository;

@Service
public class UserRoleService {
    private static final Logger log = LoggerFactory.getLogger(UserRoleService.class);
    @Autowired
    private UserRoleRepository userRoleRepository;

    public Iterable<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }


    public Iterable<UserRole> getAllByUserRolesId(List<String> userRoleIdList) {
        return userRoleRepository.findAllById(userRoleIdList);
    }

    public UserRole save(UserRole userBean) {
        return userRoleRepository.save(userBean);
    }

    public Iterable<UserRole> saveAll(List<UserRole> userRoleList) {
        return userRoleRepository.saveAll(userRoleList);
    }

    public void delete(UserRole userRole) {
        userRoleRepository.delete(userRole);
    }

    public void deleteAll(List<UserRole> userRoleList) {
        userRoleRepository.deleteAll(userRoleList);
    }

    public void deleteAll() {
        userRoleRepository.deleteAll();
    }

    public void deleteById(String userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }

    public Optional<UserRole> findById(String userRoleId) {
        return userRoleRepository.findById(userRoleId);
    }

    public boolean existsById(String userRoleId) {
        return userRoleRepository.existsById(userRoleId);
    }

    public Iterable<UserRole> findAllById(List<String> userRoleIdList) {
        return userRoleRepository.findAllById(userRoleIdList);
    }

    public Long count() {
        return userRoleRepository.count();
    }
}
