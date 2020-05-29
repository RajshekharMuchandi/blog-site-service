package com.compilednotes.blogsite.entities;

import javax.persistence.*;

@NamedQuery(name = "CONTENT.FIND_ALL",
        query = "FROM content")
@Entity(name = "content")
@Table( name = "contents")
public class ContentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "CONTENT_ID")
    private Long contentId;

    @Column( name = "MAIN_CONTENT")
    private String mainContent;

    @Column( name = "GITHUB_LINK")
    private String githubLink;

    @Column( name = "REFERENCES")
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
}
