package com.compilednotes.blogsite.service.impl;

import com.compilednotes.blogsite.beans.TopicBean;
import com.compilednotes.blogsite.beans.TopicBean;
import com.compilednotes.blogsite.entities.TopicEntity;
import com.compilednotes.blogsite.repository.TopicRepository;
import com.compilednotes.blogsite.service.TopicService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private DozerBeanMapper mapper = new DozerBeanMapper();
    
    @Override
    public void save(TopicBean topicBean) {
        TopicEntity topicEntity = new TopicEntity();
        mapper.map(topicBean,topicEntity);
        topicRepository.save(topicEntity);
    }

    @Override
    public void update(TopicBean topicBean) {
        TopicEntity topicEntity = new TopicEntity();
        mapper.map(topicBean,topicEntity);
        topicRepository.update(topicEntity);
    }

    @Override
    public void delete(Long topicId) {
        topicRepository.delete(topicRepository.findById(topicId));
    }

    @Override
    public TopicBean findById(Long topicId) {
        TopicEntity topicEntity = topicRepository.findById(topicId);
        TopicBean topicBean = new TopicBean();
        mapper.map(topicEntity,topicBean);
        return topicBean;
    }

    @Override
    public List<TopicBean> findAll() {
        return getTopicBeans(topicRepository.findAll());
    }

    private List<TopicBean> getTopicBeans(List<TopicEntity> topicEntities) {
        List<TopicBean> topicBeans = new ArrayList<>();
        for(TopicEntity topicEntity : topicEntities){
            TopicBean topicBean = new TopicBean();
            mapper.map(topicEntity,topicBean);
            topicBeans.add(topicBean);
        }
        return topicBeans;
    }
}
