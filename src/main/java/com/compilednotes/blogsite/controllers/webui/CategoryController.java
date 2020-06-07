package com.compilednotes.blogsite.controllers.webui;

import com.compilednotes.blogsite.beans.CategoryBean;
import com.compilednotes.blogsite.payload.CategoryPayload;
import com.compilednotes.blogsite.service.CategoryService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Controller("webCategoryController")
@RequestMapping("/webui/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/")
    public String home() {
        return "category-form";
    }

    @ModelAttribute("addCategory")
    private CategoryBean getCategoryBean(){
        return new CategoryBean();
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String add(ModelMap model,@ModelAttribute("addCategory")CategoryBean categoryBean, BindingResult result) {
        categoryService.save(categoryBean);
        model.put("categories", categoryService.findAll());
        return "category-display";
    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    public String get(ModelMap model) {
        model.put("categories", categoryService.findAll());
        return "category-display";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editById(@PathVariable("id") String id, Model model) {
        CategoryBean categoryBean = categoryService.findById(Long.valueOf(id));
        model.addAttribute("edit",categoryBean);
        return "category-edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("editCategory") CategoryBean categoryBean, ModelMap model) {
        categoryService.update(categoryBean);
        model.put("categories", categoryService.findAll());
        return "category-display";
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
        categoryService.delete(Long.valueOf(id));
        model.put("categories", categoryService.findAll());
        return "category-display";
    }
}
