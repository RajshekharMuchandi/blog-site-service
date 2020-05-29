package com.compilednotes.blogsite.repository;

import com.compilednotes.blogsite.entities.TopicEntity;

import java.util.List;

public interface TopicRepository {

    void save(TopicEntity topicEntity);

    void update(TopicEntity topicEntity);

    void delete(TopicEntity topicEntity);

    TopicEntity findById(Long topicId);

    List<TopicEntity> findAll();
}
