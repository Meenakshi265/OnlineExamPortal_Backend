package com.examserver.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.models.exam.Question;
import com.examserver.models.exam.Quiz;
import com.examserver.repo.QuestionRepo;
import com.examserver.services.QuestionService;

@Service
public class QuestionServiceImpl  implements QuestionService{

	@Autowired
	private QuestionRepo questionRepo;
	
	
	@Override
	public Question addQuestion(Question question) {


		return this.questionRepo.save(question);
	}

	@Override
	public Question updateQuiz(Question question) {
		
		return this.questionRepo.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
		return new HashSet<>( this.questionRepo.findAll());
	}

	@Override
	public Question getQuestion(Long quesid) {
		// TODO Auto-generated method stub
		return this.questionRepo.findById(quesid).get();
	}

	@Override
	public void deleteQuestion(Long quesid) {
		Question ques= new Question();
		ques.setQuesId(quesid);
		this.questionRepo.delete(ques);
		
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		
		return this.questionRepo.findByQuiz(quiz);
	}

}
