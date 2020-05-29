package com.compilednotes.blogsite.service.impl;

import com.compilednotes.blogsite.beans.CategoryBean;
import com.compilednotes.blogsite.entities.CategoryEntity;
import com.compilednotes.blogsite.repository.CategoryRepository;
import com.compilednotes.blogsite.service.CategoryService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    /**
     * TODO : Need to make dozer mapping generic
     * @param categoryBean
     */
    @Override
    public void save(CategoryBean categoryBean) {
        CategoryEntity categoryEntity = new CategoryEntity();
        mapper.map(categoryBean,categoryEntity);
        categoryRepository.save(categoryEntity);
    }

    @Override
    public void update(CategoryBean categoryBean) {
        CategoryEntity categoryEntity = new CategoryEntity();
        mapper.map(categoryBean,categoryEntity);
        categoryRepository.update(categoryEntity);
    }

    @Override
    public void delete(Long categoryId){
        categoryRepository.delete(categoryRepository.findById(categoryId));
    }

    @Override
    public CategoryBean findById(Long categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId);
        CategoryBean categoryBean = new CategoryBean();
        mapper.map(categoryEntity,categoryBean);
        return categoryBean;
    }

    @Override
    public List<CategoryBean> findAll() {
        return getCategoryBeans(categoryRepository.findAll());
    }

    private List<CategoryBean> getCategoryBeans(List<CategoryEntity> categoryEntities) {
        List<CategoryBean> categoryBeans = new ArrayList<>();
        for(CategoryEntity categoryEntity : categoryEntities){
            CategoryBean categoryBean = new CategoryBean();
            mapper.map(categoryEntity,categoryBean);
            categoryBeans.add(categoryBean);
        }
        return categoryBeans;
    }
}
