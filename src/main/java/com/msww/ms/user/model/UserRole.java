package com.msww.ms.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "userRole")
public class UserRole implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5986209465006271879L;
    @Id
    @Column(length = 32)
    private String roleId;
    @Column(length = 10)
    private String roleName;

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

    @Override
    public String toString() {
        return "UserRole [roleId=" + roleId + ", roleName=" + roleName + "]";
    }


}
