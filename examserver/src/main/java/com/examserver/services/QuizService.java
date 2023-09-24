package com.examserver.services;

import java.util.List;
import java.util.Set;

import com.examserver.models.exam.Category;
import com.examserver.models.exam.Quiz;

public interface QuizService {

	
	public  Quiz addQuiz(Quiz quiz);	
	public  Quiz updateQuiz(Quiz quiz);	
	public  Set<Quiz> getQuizzies();	
	public  Quiz getQuiz(Long qid);	
	public  void deleteQuiz(Long qid);
	public List<Quiz> getQuizzesOfCategory(Category category);
	
	public List<Quiz> getActiveQuizzes();
	
	public List<Quiz> getActiveQuizOfCategory(Category cat);
		
}
