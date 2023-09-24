package com.examserver.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.models.exam.Category;
import com.examserver.models.exam.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long> {

	public List<Quiz>  findByCategory(Category category);
	
	public List<Quiz> findByActive(Boolean b);
	public List<Quiz> findByCategoryAndActive(Category c,Boolean b);
}
