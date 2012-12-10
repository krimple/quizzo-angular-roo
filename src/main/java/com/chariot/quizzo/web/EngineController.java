package com.chariot.quizzo.web;

import com.chariot.quizzo.engine.QuizGenerator;
import com.chariot.quizzo.engine.QuizRunStateMachine;
import com.chariot.quizzo.engine.Session;
import com.chariot.quizzo.model.Player;
import com.chariot.quizzo.model.Quiz;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: kenrimple
 * Date: 12/6/12
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 **/
@Controller
@RequestMapping("/engine/*")
public class EngineController {

    private QuizRunStateMachine stateMachine;
    private QuizGenerator quizGenerator;

    @Autowired
    public void setStateMachine(QuizRunStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Autowired
    public void setQuizGenerator(QuizGenerator quizGenerator) {
        this.quizGenerator = quizGenerator;
    }

    @RequestMapping(method = RequestMethod.GET,
            value="/start")
    /**
     * TODO - allow multiple players
     * @param nickname
     * @param session
     * @return
     */
    public @ResponseBody String startQuizRun(
            @RequestBody String nickname,
            HttpSession session) {
        // create a random session key for this user
        UUID uuid = UUID.randomUUID();
        // stuff it in their session to identify the player
        session.setAttribute("playerKey", uuid);

        // todo - use real quiz, not one generated here
        Quiz quiz = quizGenerator.generateQuiz();
        session.setAttribute("quizId", quiz.getId());
        stateMachine.initializeQuiz(quiz);

        return "{ result: 'ok', " +
                " quiz_id: '" + quiz.getId() + "'; }";
    }

}
