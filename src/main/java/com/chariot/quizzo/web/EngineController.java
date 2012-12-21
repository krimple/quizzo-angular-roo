package com.chariot.quizzo.web;

import com.chariot.quizzo.engine.QuizGenerator;
import com.chariot.quizzo.model.Question;
import com.chariot.quizzo.model.Quiz;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
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
//
//    private QuizRunStateMachine stateMachine;
//
//    private QuizGenerator quizGenerator;
//
//    @Autowired
//    public void setStateMachine(QuizRunStateMachine stateMachine) {
//        this.stateMachine = stateMachine;
//    }
//
//    @Autowired
//    public void setQuizGenerator(QuizGenerator quizGenerator) {
//        this.quizGenerator = quizGenerator;
//    }
//
//    /**
//     * Creates an instance of the quiz for the given player and starts it.
//     * Currently only one, previously generated quiz will be created.
//     *
//     * TODO - The user specifies the /engine/start URL (not very RESTful - in future it will be
//     *        POSTed to create, PUT to update, etc)
//     *
//     * @param nickName the nickname to be used, injected as the name after /engine/start/
//     * @param session the injected HTTP Session
//     * @return A JSON result that includes the quiz_id and echoes back the nick_name used by the system
//     *
//     */
//    @RequestMapping(
//            method = RequestMethod.GET,
//            value="start/{name}",
//            produces = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public @ResponseBody String startQuizRun(
//           @PathVariable("name") String nickName,
//            HttpSession session) {
//        Quiz quiz = initializeQuiz();
//        Map<String, String> response = createQuizSession(quiz, nickName, session);
//
//
//        JSONSerializer serializer = new JSONSerializer();
//        return serializer.prettyPrint(true).serialize(response);
//    }
//
//    @RequestMapping(
//        method = RequestMethod.GET,
//        value = "question",
//        produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public @ResponseBody Question question(HttpSession session) {
//
//      Quiz quiz = Quiz.findQuiz((Long) session.getAttribute("quizId"));
//      Question question = stateMachine.askQuestion(quiz, null);
//      return question;
//    }
//
//    private Quiz initializeQuiz() {
//        // TODO - use real quiz, not one generated here
//        // TODO - don't re-initialize quiz if already created and running, just connect to it
//        return quizGenerator.generateQuiz();
//    }
//
//    private Map<String, String> createQuizSession(
//            Quiz quiz, String nickName, HttpSession session) {
//
//        Map<String, String> response = new HashMap<String, String>();
//
//        // create a random session key for this user
//        UUID uuid = UUID.randomUUID();
//
//        // TODO - organize this as a wrapper player session object - for now just hold it
//        // stuff it in their session to identify the player - don't share it with them lest they compromise security
//        session.setAttribute("playerKey", uuid);
//        session.setAttribute("nickName", nickName);
//        // store information
//        session.setAttribute("quizId", quiz.getId());
//        stateMachine.initializeQuiz(quiz);
//
//        // TODO - allow multiplayer
//        stateMachine.startQuiz(quiz);
//
//        response.put("quiz_id", Long.toString(quiz.getId()));
//        response.put("nick_name", nickName);
//        return response;
//    }
//

}
