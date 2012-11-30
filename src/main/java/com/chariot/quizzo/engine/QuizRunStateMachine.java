package com.chariot.quizzo.engine;

import com.chariot.quizzo.model.Player;
import com.chariot.quizzo.model.Quiz;
import com.chariot.quizzo.model.Team;

public interface QuizRunStateMachine {
  void startQuiz(Quiz quiz);

  void joinGame(Quiz quiz, Team team, Player player);

  void initializeQuiz(Quiz quiz);


}
