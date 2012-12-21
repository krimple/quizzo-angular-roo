package com.chariot.quizzo.service;

import com.chariot.quizzo.engine.QuizRunState;
import com.chariot.quizzo.model.Quiz;
import com.chariot.quizzo.model.QuizRun;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SimpleQuizRunService implements QuizRunService {

  @Override
  @Transactional
  public Long createQuizRun(Long quizId) {
    Quiz quiz = Quiz.findQuiz(quizId);
    QuizRun quizRun = new QuizRun();
    quizRun.setQuiz(quiz);
    quizRun.setQuizRunState(QuizRunState.READY_TO_PLAY);
    quizRun.persist();
    return quizRun.getId();
  }
}
