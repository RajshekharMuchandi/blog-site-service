package com.compilednotes.blogsite.controllers.rest;

import com.compilednotes.blogsite.beans.CategoryBean;
import com.compilednotes.blogsite.payload.CategoryPayload;
import com.compilednotes.blogsite.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    @PostMapping("/")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryBean categoryBean, UriComponentsBuilder builder) {
        categoryService.save(categoryBean);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/category/{id}").buildAndExpand(categoryBean.getCategoryName()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryBean categoryBean) {
        categoryService.update(categoryBean);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId){
        categoryService.delete(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{categoryId}")
    public CategoryPayload getCategoryById(@PathVariable Long categoryId){
       CategoryPayload categoryPayload =  new CategoryPayload();
       mapper.map(categoryService.findById(categoryId),categoryPayload);
       return categoryPayload;
    }

    @GetMapping("/")
    public List<CategoryPayload> getCategories(){
        return getCategoryPayloads(categoryService.findAll());
    }

    private List<CategoryPayload> getCategoryPayloads(List<CategoryBean> categoryBeans) {
        List<CategoryPayload> categoryPayloads = new ArrayList<>();
        for(CategoryBean categoryBean : categoryBeans){
            CategoryPayload categoryPayload = new CategoryPayload();
            mapper.map(categoryBean,categoryPayload);
            categoryPayloads.add(categoryPayload);
        }
        return categoryPayloads;
    }
}
