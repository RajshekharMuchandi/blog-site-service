package com.compilednotes.blogsite.service.impl;

import com.compilednotes.blogsite.beans.UserBean;
import com.compilednotes.blogsite.repository.TopicRepository;
import com.compilednotes.blogsite.service.UserService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private TopicRepository topicRepository;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public void save(UserBean userBean) {

    }

    @Override
    public void update(UserBean userBean) {

    }

    @Override
    public void delete(Long userId) {

    }

    @Override
    public UserBean findById(Long userId) {
        return null;
    }

    @Override
    public List<UserBean> findAll() {
        return null;
    }
}
