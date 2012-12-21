package com.chariot.quizzo.engine;


public class DefaultQuizRunStateMachineTest {
 /*
  private DefaultQuizRunStateMachine stateMachine = null;
  private Quiz uninitializedQuiz = new Quiz();
  private Quiz quizInNotStartedState = new Quiz();
  private Quiz quizInEnrollTeamsState = new Quiz();


  @Before
  public void setUp() {
    stateMachine = new DefaultQuizRunStateMachine();
    Map<Quiz, QuizRunState> quizRunStates = new HashMap<Quiz, QuizRunState>();
    quizRunStates.put(quizInNotStartedState, QuizRunState.NOT_STARTED);
    quizRunStates.put(quizInEnrollTeamsState, QuizRunState.ENROLL_TEAMS);
    stateMachine.setQuizRunStates(quizRunStates);
  }

  @Test(expected = NullPointerException.class)
  public void testStartQuizWithQuizNotInSystem() {
    stateMachine.startQuiz(uninitializedQuiz);
  }

  @Test(expected = IllegalStateException.class)
  public void testStartQuizWithQuizInSystemButNotInNotStartedState() {
    stateMachine.startQuiz(quizInEnrollTeamsState);
  }

  @Test
  public void testStartQuizHappy() {
    stateMachine.startQuiz(quizInNotStartedState);
  }

  @Test
  public void joinQuizHappy() {
    Team team = new Team();
    team.setName("Thunder Cats!");
    Player player = new Player();
    player.setNickName("Catty Catson");

    stateMachine.joinGame(quizInEnrollTeamsState, team, player);
  }
  */
}
