package com.chariot.quizzo.web;

import com.chariot.quizzo.model.Quiz;
import com.chariot.quizzo.service.QuizRunService;
import org.apache.commons.collections.map.SingletonMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;


@RequestMapping("/quiz")
@Controller
@RooWebScaffold(path = "quizzes", formBackingObject = Quiz.class)
@RooWebJson(jsonObject = Quiz.class)
@RooPlural("quiz")
public class QuizController {

  @Autowired
  public void setQuizRunService(QuizRunService quizRunService) {
    this.quizRunService = quizRunService;
  }

  private QuizRunService quizRunService;

  @RequestMapping(
      value = "{id}/start",
      produces = "application/json"
    )
  @ResponseStatus(value = HttpStatus.CREATED)
  public @ResponseBody Map startQuizRun(@PathVariable Long id, HttpSession session) {
    Long quizRunId = quizRunService.createQuizRun(id);
    String token = UUID.randomUUID().toString();
    session.setAttribute("token", token);
    session.setAttribute("quizRunId", quizRunId);
    Map map = new SingletonMap("token", token);
    return map;
  }

  @RequestMapping("{token}/askQuestion")
  public void bar() {

  }

  @RequestMapping("{token}/hasMoreQuestions")
  public void baz() {

  }

  @RequestMapping("{token}/score")
  public void bazzle() {

  }

  @RequestMapping("{token}/quit")
  public void fizzle() {

  }
}
