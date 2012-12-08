package com.chariot.quizzo.engine;

import com.chariot.quizzo.model.Player;
import com.chariot.quizzo.model.Quiz;
import com.chariot.quizzo.model.Team;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Created with IntelliJ IDEA.
 * User: kenrimple
 * Date: 11/30/12
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
@RooToString
@RooJavaBean
@Configurable

@RooJson(deepSerialize = true)
public class Session {
  private Quiz quiz;
  private Player player;
  private Team team;
}
