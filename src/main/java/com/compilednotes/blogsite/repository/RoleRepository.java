package com.compilednotes.blogsite.repository;

import com.compilednotes.blogsite.entities.RoleEntity;

import java.util.List;

public interface RoleRepository {

    void save(RoleEntity roleEntity);

    void update(RoleEntity roleEntity);

    void delete(RoleEntity roleEntity);

    RoleEntity findById(Long roleId);

    List<RoleEntity> findAll();
}
