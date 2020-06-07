package com.compilednotes.blogsite.controllers.rest;

import com.compilednotes.blogsite.beans.ContentBean;
import com.compilednotes.blogsite.payload.ContentPayload;
import com.compilednotes.blogsite.service.ContentService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController {

    @Autowired
    private ContentService contentService;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    @PostMapping("/")
    public ResponseEntity<Void> createContent(@RequestBody ContentBean contentBean, UriComponentsBuilder builder) {
        contentService.save(contentBean);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/content/{id}").buildAndExpand(contentBean.getContentId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateContent(@RequestBody ContentBean contentBean) {
        contentService.update(contentBean);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{contentId}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long contentId){
        contentService.delete(contentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{contentId}")
    public ContentPayload getContentById(@PathVariable Long contentId){
        ContentPayload contentPayload =  new ContentPayload();
        mapper.map(contentService.findById(contentId),contentPayload);
        return contentPayload;
    }

    @GetMapping("/")
    public List<ContentPayload> getContents(){
        return getContentPayloads(contentService.findAll());
    }

    private List<ContentPayload> getContentPayloads(List<ContentBean> contentBeans) {
        List<ContentPayload> contentPayloads = new ArrayList<>();
        for(ContentBean contentBean : contentBeans){
            ContentPayload contentPayload = new ContentPayload();
            mapper.map(contentBean,contentPayload);
            contentPayloads.add(contentPayload);
        }
        return contentPayloads;
    }

}
