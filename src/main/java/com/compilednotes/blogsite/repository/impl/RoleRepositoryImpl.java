package com.compilednotes.blogsite.repository.impl;

import com.compilednotes.blogsite.entities.RoleEntity;
import com.compilednotes.blogsite.entities.UserEntity;
import com.compilednotes.blogsite.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(RoleEntity roleEntity) {
       entityManager.persist(roleEntity);
    }

    @Override
    public void update(RoleEntity roleEntity) {
       entityManager.merge(roleEntity);
    }

    @Override
    public void delete(RoleEntity roleEntity) {
       entityManager.remove(roleEntity);
    }

    @Override
    public RoleEntity findById(Long roleId) {
        return entityManager.find(RoleEntity.class, roleId);
    }

    @Override
    public List<RoleEntity> findAll() {
        TypedQuery<RoleEntity> query = entityManager.createNamedQuery("ROLE.FIND_ALL",
                RoleEntity.class);
        return query.getResultList();
    }
}
