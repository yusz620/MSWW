/**
 *
 */
package com.msww.ms.user.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author andy
 *
 */
@Entity
@Table(name = "sysuser")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 2245386071785237677L;
    @Id
    @Column(length = 32)
    private String userId;
    @Column(length = 32, unique = true)
    private String userName;
    @Column(length = 32)
    private String password;
    @Column(length = 50)
    private String realName;
    @Column(length = 50)
    private String telPhone;
    @Column(length = 200)
    private String address;
    @Column(length = 10)
    private String userType;
    private boolean isActive;
    private boolean isAbled;
    @Column(length = 32)
    private String roleId;
    @Column(length = 30)
    private String roleName;
    private Date lastLogin;
    @Column(length = 32)
    private String createBy;
    private Date createTime;
    @Column(length = 32)
    private String modifyBy;
    private Date modifyTime;
    @ElementCollection
    private Set<UserRole> roles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isAbled() {
        return isAbled;
    }

    public void setAbled(boolean isAbled) {
        this.isAbled = isAbled;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", realName=" + realName + ", telPhone=" + telPhone
                + ", address=" + address + ", userType=" + userType + ", isActive=" + isActive + ", isAbled=" + isAbled + ", roleId=" + roleId + ", roleName="
                + roleName + ", lastLogin=" + lastLogin + ", createBy=" + createBy + ", createTime=" + createTime + ", modifyBy=" + modifyBy + ", modifyTime="
                + modifyTime + ", roles=" + roles + "]";
    }



}
