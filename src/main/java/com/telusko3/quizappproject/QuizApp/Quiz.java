package com.telusko3.quizappproject.QuizApp;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection ="questions")
public class Quiz {
    @Id
    private String id;

    private String question;
    private String[] options;
    private int correctOption;
    private String technology;
}
