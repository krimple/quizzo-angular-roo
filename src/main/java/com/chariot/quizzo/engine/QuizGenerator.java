package com.chariot.quizzo.engine;

import com.chariot.quizzo.model.Quiz;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 Generates a dummy quiz...
 */
public interface QuizGenerator {
    Quiz generateQuiz();
}
