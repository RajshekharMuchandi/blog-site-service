package com.compilednotes.blogsite.payload;

public class TopicPayload {

    private Long topicId;

    private String topicName;

    private CategoryPayload categoryBean;

    private ContentPayload contentBean;

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

    public CategoryPayload getCategoryBean() {
        return categoryBean;
    }

    public void setCategoryBean(CategoryPayload categoryBean) {
        this.categoryBean = categoryBean;
    }

    public ContentPayload getContentBean() {
        return contentBean;
    }

    public void setContentBean(ContentPayload contentBean) {
        this.contentBean = contentBean;
    }
}
