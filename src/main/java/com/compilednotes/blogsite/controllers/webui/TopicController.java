package com.compilednotes.blogsite.controllers.webui;

import com.compilednotes.blogsite.beans.CategoryBean;
import com.compilednotes.blogsite.beans.TopicBean;
import com.compilednotes.blogsite.service.CategoryService;
import com.compilednotes.blogsite.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller("webTopicController")
@RequestMapping("/webui/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/")
    public String home() {
        return "topic-form";
    }

    @ModelAttribute("addTopic")
    private TopicBean getTopicBean(){
        return new TopicBean();
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.POST)
    public String add(ModelMap model, @ModelAttribute("addTopic")TopicBean topicBean, BindingResult result) {
        System.out.println("topicBean :" +topicBean);
        topicService.save(topicBean);
        model.put("topics", topicService.findAll());
        return "topic-display";
    }

    @RequestMapping(value = "/getTopics", method = RequestMethod.GET)
    public String get(ModelMap model) {
        model.put("topics", topicService.findAll());
        return "topic-display";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editById(@PathVariable("id") String id, Model model) {
        TopicBean topicBean = topicService.findById(Long.valueOf(id));
        model.addAttribute("editTopic",topicBean);
        return "topic-edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("editTopic") TopicBean topicBean, ModelMap model) {
        System.out.println("topicBean : " +topicBean);
        topicService.update(topicBean);
        model.put("topics", topicService.findAll());
        return "topic-display";
    }

    /**
     * todo : Change method type to DELETE. From JSP we need to send method as delete
     * todo : through link from ajax call or jquery call
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") String id, ModelMap model) {
        topicService.delete(Long.valueOf(id));
        model.put("topics", topicService.findAll());
        return "topic-display";
    }

    @ModelAttribute("categories")
    private Map<Long, String> getCategoryList() {
        Map<Long,String> categoryMap = new HashMap<>();
        List<CategoryBean> categoryBeans = categoryService.findAll();
        for(CategoryBean categoryBean : categoryBeans){
            categoryMap.put(categoryBean.getCategoryId(),categoryBean.getCategoryName());
        }
        return categoryMap;
    }
}

