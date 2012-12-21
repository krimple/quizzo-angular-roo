package com.chariot.quizzo.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

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

    private String description;

    @OneToMany(mappedBy = "quiz")
    private Set<Question> questions = new HashSet<Question>();

}
