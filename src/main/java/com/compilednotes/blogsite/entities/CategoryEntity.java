package com.compilednotes.blogsite.entities;

import javax.persistence.*;
import java.util.List;

@NamedQuery(name = "CATEGORY.FIND_ALL",
        query = "FROM category")
@Entity(name = "category")
@Table( name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "CATEGORY_ID")
    private Long categoryId;

    @Column( name = "CATEGORY_NAME")
    private String categoryName;

    @OneToMany(mappedBy = "categoryEntity")
    private List<TopicEntity> topicEntityList;

    public List<TopicEntity> getTopicEntityList() {
        return topicEntityList;
    }

    public void setTopicEntityList(List<TopicEntity> topicEntityList) {
        this.topicEntityList = topicEntityList;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categorId) {
        this.categoryId = categorId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
