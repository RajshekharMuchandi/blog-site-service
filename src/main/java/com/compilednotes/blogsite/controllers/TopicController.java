package com.compilednotes.blogsite.controllers;

import com.compilednotes.blogsite.beans.TopicBean;
import com.compilednotes.blogsite.payload.TopicPayload;
import com.compilednotes.blogsite.service.TopicService;
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
@RequestMapping("/topics")
public class TopicController {

        @Autowired
        private TopicService topicService;

        private DozerBeanMapper mapper = new DozerBeanMapper();

        @PostMapping("/")
        public ResponseEntity<Void> createTopic(@RequestBody TopicBean topicBean, UriComponentsBuilder builder) {
        topicService.save(topicBean);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/topic/{id}").buildAndExpand(topicBean.getTopicName()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

        @PutMapping("/")
        public ResponseEntity<Void> updateTopic(@RequestBody TopicBean topicBean) {
        topicService.update(topicBean);
        return new ResponseEntity<>(HttpStatus.OK);
    }

        @DeleteMapping("/{topicId}")
        public ResponseEntity<Void> deleteTopic(@PathVariable Long topicId){
        topicService.delete(topicId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

        @GetMapping("/{topicId}")
        public TopicPayload getTopicById(@PathVariable Long topicId){
        TopicPayload topicPayload =  new TopicPayload();
        mapper.map(topicService.findById(topicId),topicPayload);
        return topicPayload;
    }

        @GetMapping("/")
        public List<TopicPayload> getTopics(){
        return getTopicPayloads(topicService.findAll());
    }

        private List<TopicPayload> getTopicPayloads(List< TopicBean > topicBeans) {
        List<TopicPayload> topicPayloads = new ArrayList<>();
        for(TopicBean topicBean : topicBeans){
            TopicPayload topicPayload = new TopicPayload();
            mapper.map(topicBean,topicPayload);
            topicPayloads.add(topicPayload);
        }
        return topicPayloads;
    }
    
}
