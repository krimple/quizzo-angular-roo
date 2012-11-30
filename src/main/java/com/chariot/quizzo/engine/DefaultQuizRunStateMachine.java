package com.chariot.quizzo.engine;

import com.chariot.quizzo.model.Player;
import com.chariot.quizzo.model.Quiz;
import com.chariot.quizzo.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kenrimple
 * Date: 11/30/12
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public final class DefaultQuizRunStateMachine implements QuizRunStateMachine {

  Logger logger = LoggerFactory.getLogger(getClass());

  private Map<Quiz, QuizRunState> quizRunStates = new HashMap<Quiz, QuizRunState>();

  // for testability and for reconstituting in a shut-down server
  protected void setQuizRunStates(Map<Quiz, QuizRunState> quizRunStates) {
    this.quizRunStates = quizRunStates;
  }

  protected Map<Quiz, QuizRunState> getQuizRunStates() {
    return quizRunStates;
  }

  @Override
  public void initializeQuiz(Quiz quiz) {
    if (isValidQuiz(quiz)) {
      throw new IllegalStateException("Trying to initialize an already extant quiz.");
    }

    this.quizRunStates.put(quiz, QuizRunState.NOT_STARTED);
  }

  @Override
  public void startQuiz(Quiz quiz) {

    if (!isValidQuiz(quiz)) {
      throw new NullPointerException("cannot start quiz - does not exist");
    }

    // can only be in the NOT_STARTED state to start a quiz
    if (quizRunStates.get(quiz) == QuizRunState.NOT_STARTED) {
      quizRunStates.put(quiz, QuizRunState.ENROLL_TEAMS);
    } else {
      throw new IllegalStateException("cannot start quiz that is not in system or does not exist.");
    }
  }

  @Override
  public void joinGame(Quiz quiz, Team team, Player player) {
    if (!isValidQuiz(quiz)) {
      throw new NullPointerException("cannot start quiz - does not exist");
    }

    if (quizRunStates.get(quiz) != QuizRunState.ENROLL_TEAMS) {
      throw new IllegalStateException("Must be enrolling teams to join a quiz.");
    }
  }

  private boolean isValidQuiz(Quiz quiz) {
    return quizRunStates.get(quiz) != null;
  }
}
