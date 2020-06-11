package com.compilednotes.blogsite.beans;

public class TopicBean {

    private Long topicId;

    private String topicName;

    private CategoryBean categoryBean;

    private ContentBean contentBean;

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

    public CategoryBean getCategoryBean() {
        return categoryBean;
    }

    public void setCategoryBean(CategoryBean categoryBean) {
        this.categoryBean = categoryBean;
    }

    public ContentBean getContentBean() {
        return contentBean;
    }

    public void setContentBean(ContentBean contentBean) {
        this.contentBean = contentBean;
    }

    @Override
    public String toString() {
        return "TopicBean{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                ", categoryBean=" + categoryBean +
                ", contentBean=" + contentBean +
                '}';
    }
}
