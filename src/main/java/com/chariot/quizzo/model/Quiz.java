package com.chariot.quizzo.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson(deepSerialize = true)
@RooPlural("Quizzes")
public class Quiz {

    private String name;

    private String short_name;

    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "game_member",
      joinColumns = {
            @JoinColumn(name = "quiz_id")},
      inverseJoinColumns = {
            @JoinColumn(name = "player_id")})
    private Set<Player> players = new HashSet<Player>();
}
