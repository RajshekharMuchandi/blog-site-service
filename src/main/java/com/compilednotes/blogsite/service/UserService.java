package com.compilednotes.blogsite.service;

import com.compilednotes.blogsite.beans.UserBean;

import java.util.List;

/**
 *  Operations related to user and roles
 */
public interface UserService {

    void save(UserBean userBean);

    void update(UserBean userBean);

    void delete(Long userId);

    UserBean findById(Long userId);

    List<UserBean> findAll();
}
