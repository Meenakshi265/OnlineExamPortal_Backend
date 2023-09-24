package com.examserver.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.models.exam.Question;
import com.examserver.models.exam.Quiz;

public interface QuestionRepo extends JpaRepository<Question , Long> {

	public Set<Question> findByQuiz(Quiz quiz);

}
