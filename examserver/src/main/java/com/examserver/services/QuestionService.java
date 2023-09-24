package com.examserver.services;

import java.util.Set;

import com.examserver.models.exam.Question;
import com.examserver.models.exam.Quiz;

public interface QuestionService {
	public  Question addQuestion(Question question);	
	public  Question updateQuiz(Question question);	
	public  Set<Question> getQuestions();	
	public  Question getQuestion(Long quesid);	
	public  void deleteQuestion(Long quesid);	
	
	 public Set<Question> getQuestionOfQuiz(Quiz quiz);

}
