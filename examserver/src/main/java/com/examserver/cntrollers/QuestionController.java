package com.examserver.cntrollers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examserver.Utils;
import com.examserver.models.exam.Category;
import com.examserver.models.exam.Question;
import com.examserver.models.exam.Quiz;
import com.examserver.services.QuestionService;
import com.examserver.services.QuizService;


@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	@Autowired
	private Utils utils;
	
	// add question
		@PostMapping("/")
		public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
			
			Question question1=this.questionService	.addQuestion(question);
			
			return ResponseEntity.ok(question1);
			
		}
		
		@PutMapping("/")
		public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
			
			Question question1=this.questionService.addQuestion(question);
			
			return ResponseEntity.ok(question1);
			
		}
		
		
		
		// question 
		@GetMapping("/quiz/{quizId}")
		public ResponseEntity<?> getquestions(@PathVariable("quizId")Long quizId) {	
				Quiz quiz=this.quizService.getQuiz(quizId);
				System.out.println(quiz);
			    Set<Question> setquestion=quiz.getQuestion();
			  
			    List<Question> list=new  ArrayList<>(setquestion);
			    list.forEach((q)->{
			                  System.out.println(q);  
			                  }
			    );
			    if(list.size()>Integer.parseInt(quiz.getNumberOfQuestion())) {
			    	System.out.println("quiz.getNumberOfQuestion()==="+quiz.getNumberOfQuestion());
			    	list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion())+1);
			    	
			    }
			    
			    list.forEach((q)->{
			    	q.setAnswer("");
			    });
			Collections.shuffle(list);
			return  ResponseEntity.ok(list);
					
			
		}
		
		
		
		@GetMapping("/quiz/all/{quizId}")
		public ResponseEntity<?> getquestionsAdmin(@PathVariable("quizId")Long quizId) {	
				Quiz quiz=this.quizService.getQuiz(quizId);
				System.out.println(quiz);
			    Set<Question> setquestion=quiz.getQuestion();
			    System.out.println();
			    List list=new  ArrayList<>(setquestion);
			    
			return  ResponseEntity.ok(list);
					
			
		}
		
		
		//get the  get single quietion
		@GetMapping("/{quesId}")
		public Question getCategory(@PathVariable("quesId") Long quesId) {
			
			return this.questionService.getQuestion(quesId);
			
			
		}
		
		
		// delete  question 
		@DeleteMapping("/{quesId}")
	      public void deleteCategory(@PathVariable("quesId")   Long quesId) {
			this.questionService.deleteQuestion(quesId);
	    	  
	      }
		
		//Evaluate quiz 
		@PostMapping("/eval-quiz")
		public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
			 Integer gotMarks=0;
			 Integer attempted=0;
			 Integer correctAnswer=0;
			 
			 
			for(Question q:questions){
				Question q1= this.questionService.getQuestion(q.getQuesId());
				if( q.getGivenAnswer()!=null &&q.getGivenAnswer().trim().equals(q1.getAnswer().trim())) {
					correctAnswer++;
				}
				if(q.getGivenAnswer()!=null){
					attempted++;
					
				}
			}
			
			
		Map<String,Object>	map=Map.of("correctAnswer",correctAnswer,"attempted",attempted);
			return ResponseEntity.ok(map);
		}
		
	
}
