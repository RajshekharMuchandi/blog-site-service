package com.compilednotes.blogsite.service;

import com.compilednotes.blogsite.beans.ContentBean;

import java.util.List;

/**
 * Operations related to the content
 */
public interface ContentService {

    void save(ContentBean contentBean);

    void update(ContentBean contentBean);

    void delete(Long contentId);

    ContentBean findById(Long contentId);

    List<ContentBean> findAll();
}
