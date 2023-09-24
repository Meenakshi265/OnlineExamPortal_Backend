package com.examserver.cntrollers;

import java.util.List;
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

import com.examserver.models.exam.Category;
import com.examserver.models.exam.Quiz;
import com.examserver.services.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	// add Quiz
		@PostMapping("/")
		public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
			
			Quiz quiz1=this.quizService.addQuiz(quiz);
			
			return ResponseEntity.ok(quiz1);
			
		}
		
		//get the  category
		@GetMapping("/{quizId}")
		public Quiz getCategory(@PathVariable("quizId") Long quizId) {
			
			return this.quizService.getQuiz(quizId);
			
			
		}
		
		@GetMapping("/")
		public Set<Quiz> getCategory() {	
			return this.quizService.getQuizzies();
			
		}
		
		// update 
		@PutMapping("/")
		public Quiz addupdate(@RequestBody Quiz quiz) {
			
			Quiz quiz1=this.quizService.updateQuiz(quiz);
			
			return quiz1;
			
		}

		// delete  category 
		@DeleteMapping("/{quizId}")
	      public void deleteCategory(@PathVariable("quizId")   Long quizid) {
			System.out.println("delete of quiz...........");
			this.quizService.deleteQuiz(quizid);
	    	  
	      }
		
		// get quizzes by category
		
		@GetMapping("/category/{cid}")
		public List<Quiz>  getQuizzesOfCategory(@PathVariable("cid") Long cid){
			 Category category=new Category();
			 category.setCid(cid);
			return this.quizService.getQuizzesOfCategory(category);
		}
		
	//get alll active quiz
		@GetMapping("/active/")
		public List<Quiz> getActiveQuiz(){
			return this.quizService.getActiveQuizzes();
		}
		@GetMapping("/category/active/{cid}")
		public List<Quiz> getActiveQuiz(@PathVariable("cid") Long cid){
			 Category category=new Category();
			 category.setCid(cid);
			return this.quizService.getActiveQuizOfCategory(category);
		}
}
