package com.quanta.controller;

import com.quanta.model.Question;
import com.quanta.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.saveQuestion(question));
    }

    @GetMapping("/test/{testId}")
    public ResponseEntity<List<Question>> getQuestions(@PathVariable Long testId) {
        return ResponseEntity.ok(questionService.getQuestionsByTest(testId));
    }
}