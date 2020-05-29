package com.compilednotes.blogsite.service;

import com.compilednotes.blogsite.beans.CategoryBean;

import java.util.List;

/**
 * Operations related to the category
 */
public interface CategoryService {

    void save(CategoryBean categoryBean);

    void update(CategoryBean categoryBean);

    void delete(Long categoryId);

    CategoryBean findById(Long categoryId);

    List<CategoryBean> findAll();
}
