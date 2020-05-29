package com.compilednotes.blogsite.repository.impl;


import com.compilednotes.blogsite.entities.CategoryEntity;
import com.compilednotes.blogsite.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(CategoryEntity categoryEntity) {
        entityManager.persist(categoryEntity);
    }

    @Override
    public void update(CategoryEntity categoryEntity) {
       entityManager.merge(categoryEntity);
    }

    @Override
    public void delete(CategoryEntity categoryEntity) {
       entityManager.remove(categoryEntity);
    }

    @Override
    public CategoryEntity findById(Long categoryId) {
        return entityManager.find(CategoryEntity.class,categoryId);
    }

    @Override
    public List<CategoryEntity> findAll() {
        TypedQuery<CategoryEntity> query = entityManager.createNamedQuery("CATEGORY.FIND_ALL",
                CategoryEntity.class);
        return query.getResultList();
    }
}
