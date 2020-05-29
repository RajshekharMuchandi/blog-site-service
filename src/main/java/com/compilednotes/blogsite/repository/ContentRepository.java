package com.compilednotes.blogsite.repository;

import com.compilednotes.blogsite.entities.ContentEntity;

import java.util.List;

public interface ContentRepository {

    void save(ContentEntity contentEntity);

    void update(ContentEntity contentEntity);

    void delete(ContentEntity contentEntity);

    ContentEntity findById(Long contentId);

    List<ContentEntity> findAll();
}
