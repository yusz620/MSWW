package com.msww.ms.user.mockdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msww.ms.user.model.SysUser;
import com.msww.ms.utils.EncodeUtils;


public class MockUserData {
    private static final Logger log = LoggerFactory.getLogger(MockUserData.class);

    public static SysUser mockUser() {
        SysUser user = new SysUser();
        user.setAbled(true);
        user.setActive(true);
        user.setAddress("武汉");
        user.setCreateBy("root");
        user.setCreateTime(new Date());
        user.setLastLogin(new Date());
        user.setModifyBy("root");
        user.setModifyTime(new Date());
        try {
            user.setPassword(EncodeUtils.md5Encode("asdf1234"));
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
        user.setRealName("root");
        user.setRoleId(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setRoleName("admin");
        user.setTelPhone("12345678");
        user.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setUserName("root");
        user.setUserType("test");
        return user;
    }

    public static List<SysUser> mockUserList() {
        List<SysUser> userlist = new ArrayList<>();
        userlist.add(mockUser());
        SysUser user = mockUser();
        user.setUserName("andy");
        return userlist;
    }
}
