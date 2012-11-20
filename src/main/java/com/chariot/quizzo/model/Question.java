package com.chariot.quizzo.model;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Question {

  @NotNull
  @Size(max = 1000)
  private String questionText;

  @NotNull
  @OrderColumn(name = "sort_order")
  private short sortOrder;

  @ManyToOne
  @JoinColumn(name = "quiz_id")
  private Quiz quiz;

  @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  private Set<Choice> choices = new HashSet<Choice>();

}
