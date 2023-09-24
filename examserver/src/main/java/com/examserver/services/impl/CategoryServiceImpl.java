 package com.examserver.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.models.exam.Category;
import com.examserver.models.exam.Quiz;
import com.examserver.repo.CategoryRepo;
import com.examserver.services.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return this.categoryRepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return  new HashSet<> (this.categoryRepo.findAll());
	}

	@Override
	public Category getCategory(Long cid) {


		return this.categoryRepo.findById(cid).get();
	}

	@Override
	public void deleteCategory(Long cid) {

		 Category category= new Category();
		 category.setCid(cid);
				 
		
		 this.categoryRepo.delete(category);
	}

}
