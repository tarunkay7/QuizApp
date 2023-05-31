package com.telusko3.quizappproject.QuizApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz updateQuizById(String id, Quiz quiz) {
        Quiz quizToUpdate = quizRepository.findQuizById(id);
        if (quizToUpdate != null) {
            quizToUpdate.setQuestion(quiz.getQuestion());
            quizToUpdate.setOptions(quiz.getOptions());
            quizToUpdate.setCorrectOption(quiz.getCorrectOption());
            quizToUpdate.setTechnology(quiz.getTechnology());
            return quizRepository.save(quizToUpdate);
        }
        return null;
    }

    public boolean deleteQuizById(String id) {
        Quiz quizToDelete = quizRepository.findQuizById(id);
        if (quizToDelete != null) {
            quizRepository.delete(quizToDelete);
            return true;
        }
        return false;
    }

    public Quiz getQuizById(String id) {
        return quizRepository.findQuizById(id);
    }
}
