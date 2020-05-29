package com.compilednotes.blogsite.repository.impl;

import com.compilednotes.blogsite.entities.CategoryEntity;
import com.compilednotes.blogsite.entities.ContentEntity;
import com.compilednotes.blogsite.repository.ContentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ContentRepositoryImpl implements ContentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ContentEntity contentEntity) {
        entityManager.persist(contentEntity);
    }

    @Override
    public void update(ContentEntity contentEntity) {
          entityManager.merge(contentEntity);
    }

    @Override
    public void delete(ContentEntity contentEntity) {
          entityManager.remove(contentEntity);
    }

    @Override
    public ContentEntity findById(Long contentId) {
        return entityManager.find(ContentEntity.class, contentId);
    }

    @Override
    public List<ContentEntity> findAll() {
        TypedQuery<ContentEntity> query = entityManager.createNamedQuery("CONTENT.FIND_ALL",
                ContentEntity.class);
        return query.getResultList();
    }
}
