package com.compilednotes.blogsite.repository;

import com.compilednotes.blogsite.entities.CategoryEntity;

import java.util.List;

public interface CategoryRepository {

    void save(CategoryEntity categoryEntity);

    void update(CategoryEntity categoryEntity);

    void delete(CategoryEntity categoryEntity);

    CategoryEntity findById(Long categoryId);

    List<CategoryEntity> findAll();
}
