package com.chariot.quizzo.web;

import com.chariot.quizzo.engine.QuizGenerator;
import com.chariot.quizzo.model.Quiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kenrimple
 * Date: 12/21/12
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/generator/*")
public class GeneratorController {

  private QuizGenerator quizGenerator;

  @RequestMapping(value = "/generate",
    produces = "application/json")
  public String generate() {
    Quiz quiz = quizGenerator.generateQuiz();
    return "{ 'quiz' : '" + quiz.getId().toString() + "' }";
  }
}
