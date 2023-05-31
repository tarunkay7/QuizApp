package com.telusko3.quizappproject.QuizApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/all")
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable String id) {
        return quizService.getQuizById(id);
    }

    @PutMapping("/update/{id}")
    public String updateQuizById(@PathVariable String id, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.updateQuizById(id, quiz);
        if (updatedQuiz != null) {
            return "Update Success";
        } else {
            return "Quiz not found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuizById(@PathVariable String id) {
        boolean deleted = quizService.deleteQuizById(id);
        if (deleted) {
            return "Delete Success";
        } else {
            return "Quiz not found";
        }
    }
}
