package com.chariot.quizzo.web;

import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chariot.quizzo.db.Quiz;


@RequestMapping("/quizzes")
@Controller
@RooWebScaffold(path = "quizzes", formBackingObject = Quiz.class)
@RooWebJson(jsonObject = com.chariot.quizzo.db.Quiz.class)
@RooPlural("quizzes")
public class QuizController { 
}
