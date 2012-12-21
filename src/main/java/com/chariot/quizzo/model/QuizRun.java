package com.chariot.quizzo.model;

import com.chariot.quizzo.engine.QuizRunState;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooSerializable
@RooJson
public class QuizRun {
  @NotNull
  @ManyToOne
  @JoinColumn(name = "quiz_id")
  private Quiz quiz;

  private QuizRunState quizRunState;

}
