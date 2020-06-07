package com.compilednotes.blogsite.controllers.webui;

import com.compilednotes.blogsite.beans.ContentBean;
import com.compilednotes.blogsite.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("webContentController")
@RequestMapping("/webui/contents")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/")
    public String home() {
        return "content-form";
    }

    @ModelAttribute("addContent")
    private ContentBean getContentBean(){
        return new ContentBean();
    }

    @RequestMapping(value = "/addContent", method = RequestMethod.POST)
    public String add(ModelMap model, @ModelAttribute("addContent")ContentBean contentBean, BindingResult result) {
        contentService.save(contentBean);
        model.put("contents", contentService.findAll());
        return "content-display";
    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    public String get(ModelMap model) {
        model.put("contents", contentService.findAll());
        return "content-display";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editById(@PathVariable("id") String id, Model model) {
        ContentBean contentBean = contentService.findById(Long.valueOf(id));
        model.addAttribute("edit",contentBean);
        return "content-edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("editContent") ContentBean contentBean, ModelMap model) {
        contentService.update(contentBean);
        model.put("contents", contentService.findAll());
        return "content-display";
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
        contentService.delete(Long.valueOf(id));
        model.put("contents", contentService.findAll());
        return "content-display";
    }
}
