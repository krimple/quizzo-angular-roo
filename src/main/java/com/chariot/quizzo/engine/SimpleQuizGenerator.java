package com.chariot.quizzo.engine;

import com.chariot.quizzo.model.Answer;
import com.chariot.quizzo.model.Choice;
import com.chariot.quizzo.model.Question;
import com.chariot.quizzo.model.Quiz;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.beans.PersistenceDelegate;
import java.math.BigDecimal;
import java.util.*;

@Component
@Transactional
public class SimpleQuizGenerator implements QuizGenerator {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public Quiz generateQuiz() {
        Quiz quiz = new Quiz();
        quiz.setName("Demo Quiz");
        quiz.setShortName("Demo");
        quiz.setDescription("This is a demo quiz");

        createQuestion(
                quiz,
                "What is your name",
                3,
                "John Cleese",
                "Eric Idle",
                "Chevy Chase",
                "Sir Arthur");

        createQuestion(
                quiz,
                "What is your quest",
                2,
                "I seek chickens",
                "I seek parrots",
                "I seek the holy grail");

        createQuestion(
                quiz,
                "What is the average air speed of a swallow",
                2,
                "20 miles per hour",
                "1 second",
                "African or European?");
        em.persist(quiz);
        return quiz;
    }

    private Question createQuestion(
            Quiz quiz,
            String text,
            int correctAnswer,
            String... choiceTextValues) {

        Question question = new Question();
        question.setQuestionText(text);
        question.setQuiz(quiz);
        Set<Choice> choices = new TreeSet<Choice>();

        for(int i = 0; i < choiceTextValues.length; i++) {
            Choice choice = new Choice();
            choice.setCorrect(correctAnswer == i);
            choice.setText(choiceTextValues[i]);
            choice.setPointValue(BigDecimal.valueOf(1.0d));
            choice.setSortOrder((short) i);
            choices.add(choice);
        }
        question.setChoices(choices);

        return question;
    }
}
