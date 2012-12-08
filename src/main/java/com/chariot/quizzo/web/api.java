package com.chariot.quizzo.web;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Created with IntelliJ IDEA.
 * User: kenrimple
 * Date: 12/6/12
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class api {
    @RooJavaBean
    @RooToString
    @RooJson
    public static class QuizStartRequest {
        private String playerName;
        private int quizId;
    }
}
