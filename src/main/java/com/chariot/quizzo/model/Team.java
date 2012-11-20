package com.chariot.quizzo.model;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooSerializable
@RooJson
public class Team {

  @NotNull
  @Size(max = 80)
  private String name;

  @NotNull
  private String mission;

  @OneToMany(mappedBy = "team")
  private Set<Answer> answers = new HashSet<Answer>();

  @ManyToOne
  @JoinColumn(name = "quiz_run_id")
  private QuizRun quizRun;

  @Transient
  public BigDecimal calculateTotalScore() {
    BigDecimal score = new BigDecimal("0.0");
    for (Answer answer: answers) {
      score = score.add(answer.calculateScore());
    }
    return score;
  }
}
