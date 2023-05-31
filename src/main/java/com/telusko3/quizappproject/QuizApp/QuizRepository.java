package com.telusko3.quizappproject.QuizApp;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
    Quiz findQuizById(String id);
    // No need to modify the findById method
}
