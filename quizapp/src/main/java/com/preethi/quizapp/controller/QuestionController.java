package com.preethi.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preethi.quizapp.model.Question;
import com.preethi.quizapp.service.QuestionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name="CRUD Operations")
@RestController
@RequestMapping("question")
public class QuestionController {
	
	
	@Autowired
	QuestionService questionService;
	
	@Operation(summary="displaying all questions")
	@ApiResponse(responseCode="201",description="Http 201 created")

	@GetMapping("allQuestions")
	@Transactional(readOnly = false)
	public ResponseEntity<List<Question>>getAllQuestions() {
		
		return questionService.getAllQuestions();
	}
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>>getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
		
	}
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
		
	}
}
