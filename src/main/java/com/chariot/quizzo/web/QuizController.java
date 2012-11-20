package com.chariot.quizzo.web;

import com.chariot.quizzo.model.Quiz;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/quizzes")
@Controller
@RooWebScaffold(path = "quizzes", formBackingObject = Quiz.class)
@RooWebJson(jsonObject = Quiz.class)
@RooPlural("quizzes")
public class QuizController { 
}
