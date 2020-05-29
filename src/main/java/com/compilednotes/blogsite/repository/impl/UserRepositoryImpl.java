package com.compilednotes.blogsite.repository.impl;

import com.compilednotes.blogsite.entities.TopicEntity;
import com.compilednotes.blogsite.entities.UserEntity;
import com.compilednotes.blogsite.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
       entityManager.merge(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
       entityManager.remove(userEntity);
    }

    @Override
    public UserEntity findById(Long userId) {
        return entityManager.find(UserEntity.class, userId);
    }

    @Override
    public List<UserEntity> findAll() {
        TypedQuery<UserEntity> query = entityManager.createNamedQuery("USER.FIND_ALL",
                UserEntity.class);
        return query.getResultList();
    }
}
