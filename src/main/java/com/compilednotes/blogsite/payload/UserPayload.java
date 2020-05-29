package com.compilednotes.blogsite.payload;

public class UserPayload {

    private Long userId;

    private String userName;

    private String password;

    private RolePayload roleBean;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public RolePayload getRoleBean() {
        return roleBean;
    }

    public void setRoleBean(RolePayload roleBean) {
        this.roleBean = roleBean;
    }
}
