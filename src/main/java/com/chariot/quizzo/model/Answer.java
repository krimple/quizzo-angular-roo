package com.chariot.quizzo.model;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Answer {

  @ManyToOne
  @JoinColumn(name = "answer_id")
  private Choice choice;

  @Column(name = "point_value")
  private int pointValue;

//  @Transient
//  public BigDecimal calculateScore() {
//    return (choice.getCorrect() ? new BigDecimal("1.0") : BigDecimal.ZERO);
//  }
}
