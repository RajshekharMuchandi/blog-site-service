package com.compilednotes.blogsite.beans;

public class ContentBean {

    private Long contentId;

    private String mainContent;

    private String githubLink;

    private String references;

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "ContentBean{" +
                "contentId=" + contentId +
                ", mainContent='" + mainContent + '\'' +
                ", githubLink='" + githubLink + '\'' +
                ", references='" + references + '\'' +
                '}';
    }
}
