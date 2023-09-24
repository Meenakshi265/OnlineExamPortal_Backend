package com.examserver.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.examserver.models.exam.Category;
import com.examserver.models.exam.Quiz;
import com.examserver.repo.QuizRepo;
import com.examserver.services.QuizService;

@Service
public class  QuizServiceImpl  implements QuizService {
    @Autowired
	private QuizRepo quizRepo;
	
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizRepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzies() {
		
		return new HashSet<> (this.quizRepo.findAll());
	}

	@Override
	public Quiz getQuiz(Long qid) {
		
		return this.quizRepo.findById(qid).get();
	}

	@Override
	public void deleteQuiz(Long qid) {
		
		 this.quizRepo.deleteById(qid);;
		 
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		
		return this.quizRepo.findByCategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizzes() {
		
		return this.quizRepo.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizOfCategory(Category cat) {

		return this.quizRepo.findByCategoryAndActive(cat, true);
	}
		 }
