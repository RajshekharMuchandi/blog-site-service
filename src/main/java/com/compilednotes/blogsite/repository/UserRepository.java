package com.compilednotes.blogsite.repository;

import com.compilednotes.blogsite.entities.UserEntity;

import java.util.List;

public interface UserRepository {

    void save(UserEntity userEntity);

    void update(UserEntity userEntity);

    void delete(UserEntity userEntity);

    UserEntity findById(Long userId);

    List<UserEntity> findAll();
}
