// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.chariot.quizzo.model;

import com.chariot.quizzo.model.Answer;
import com.chariot.quizzo.model.Choice;

privileged aspect Answer_Roo_JavaBean {
    
    public Choice Answer.getChoice() {
        return this.choice;
    }
    
    public void Answer.setChoice(Choice choice) {
        this.choice = choice;
    }
    
    public int Answer.getPointValue() {
        return this.pointValue;
    }
    
    public void Answer.setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }
    
}
