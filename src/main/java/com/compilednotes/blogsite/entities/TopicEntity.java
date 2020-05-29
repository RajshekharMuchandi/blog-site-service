package com.compilednotes.blogsite.entities;

import javax.persistence.*;
import java.util.List;

@NamedQuery(name = "TOPIC.FIND_ALL",
        query = "FROM topic")
@Entity(name = "topic")
@Table( name = "topics")
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOPIC_ID")
    private Long topicId;

    @Column(name = "TOPIC_NAME")
    private String topicName;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private CategoryEntity categoryEntity;

    @OneToMany
    @JoinColumn(name = "CONTENT_ID")
    private List<ContentEntity> contentEntity;

    public List<ContentEntity> getContentEntity() {
        return contentEntity;
    }

    public void setContentEntity(List<ContentEntity> contentEntity) {
        this.contentEntity = contentEntity;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
