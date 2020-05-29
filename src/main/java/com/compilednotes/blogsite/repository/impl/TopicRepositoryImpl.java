package com.compilednotes.blogsite.repository.impl;

import com.compilednotes.blogsite.entities.TopicEntity;
import com.compilednotes.blogsite.repository.TopicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TopicRepositoryImpl implements TopicRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(TopicEntity topicEntity) {
        entityManager.persist(topicEntity);
    }

    @Override
    public void update(TopicEntity topicEntity) {
        entityManager.merge(topicEntity);
    }

    @Override
    public void delete(TopicEntity topicEntity) {
        entityManager.remove(topicEntity);
    }

    @Override
    public TopicEntity findById(Long topicId) {
        return entityManager.find(TopicEntity.class,topicId);
    }

    @Override
    public List<TopicEntity> findAll() {
        TypedQuery<TopicEntity> query = entityManager.createNamedQuery("TOPIC.FIND_ALL",
                TopicEntity.class);
        return query.getResultList();
    }
}
