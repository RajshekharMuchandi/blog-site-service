package com.compilednotes.blogsite.service.impl;

import com.compilednotes.blogsite.beans.ContentBean;
import com.compilednotes.blogsite.entities.ContentEntity;
import com.compilednotes.blogsite.repository.ContentRepository;
import com.compilednotes.blogsite.service.ContentService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public void save(ContentBean contentBean) {
        ContentEntity contentEntity = new ContentEntity();
        mapper.map(contentBean,contentEntity);
        contentRepository.save(contentEntity);
    }

    @Override
    public void update(ContentBean contentBean) {
        ContentEntity contentEntity = new ContentEntity();
        mapper.map(contentBean,contentEntity);
        contentRepository.update(contentEntity);
    }

    @Override
    public void delete(Long contentId) {
        contentRepository.delete(contentRepository.findById(contentId));
    }

    @Override
    public ContentBean findById(Long contentId) {
        ContentEntity contentEntity = contentRepository.findById(contentId);
        ContentBean contentBean = new ContentBean();
        mapper.map(contentEntity,contentBean);
        return contentBean;
    }

    @Override
    public List<ContentBean> findAll() {
        return getContentBeans(contentRepository.findAll());
    }

    private List<ContentBean> getContentBeans(List<ContentEntity> contentEntities) {
        List<ContentBean> contentBeans = new ArrayList<>();
        for (ContentEntity contentEntity : contentEntities) {
            ContentBean contentBean = new ContentBean();
            mapper.map(contentEntity, contentBean);
            contentBeans.add(contentBean);
        }
        return contentBeans;
    }
}
