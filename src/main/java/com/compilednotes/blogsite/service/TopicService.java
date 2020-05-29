package com.compilednotes.blogsite.service;

import com.compilednotes.blogsite.beans.TopicBean;

import java.util.List;

/**
 * Operations related to the topic
 */
public interface TopicService {

    void save(TopicBean topicBean);

    void update(TopicBean topicBean);

    void delete(Long topicId);

    TopicBean findById(Long topicId);

    List<TopicBean> findAll();
}
