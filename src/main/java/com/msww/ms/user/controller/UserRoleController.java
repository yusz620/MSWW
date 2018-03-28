package com.msww.ms.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msww.ms.user.model.UserRole;
import com.msww.ms.user.service.UserRoleService;

@RestController
@RequestMapping(value = "/roles")
public class UserRoleController {
    private static final Logger log = LoggerFactory.getLogger(UserRoleController.class);
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<UserRole> getAllUserRoles(Model model) {
        return userRoleService.getAllUserRoles();
    }
}
