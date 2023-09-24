package com.examserver.cntrollers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.examserver.Utils;
import com.examserver.models.exam.Category;
import com.examserver.services.CategoryService;
import com.examserver.services.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	

	
	// add category
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		
		Category category1=this.categoryService.addCategory(category);
		
		return ResponseEntity.ok(category1);
		
	}

	//get the  category
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		
		return this.categoryService.getCategory(categoryId);
		
		
	}
	
	@GetMapping("/")
	public Set<Category> getCategory() {	
		return this.categoryService.getCategories();
		
	}
	
	
	
	// update 
	@PutMapping("/")
	public Category addupdate(@RequestBody Category category) {
		
		Category category1=this.categoryService.updateCategory(category);
		
		return category1 ;
		
	}

	// delete  category 
	@DeleteMapping("/{categoryId}")
      public void deleteCategory(@PathVariable("categoryId")   Long cid) {
		this.categoryService.deleteCategory(cid);
    	  
      }
	
	
	
}
