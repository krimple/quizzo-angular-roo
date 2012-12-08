package com.chariot.quizzo.web;

import com.chariot.quizzo.engine.QuizGenerator;
import com.chariot.quizzo.engine.QuizRunStateMachine;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
 "classpath:META-INF/spring/applicationContext*.xml",
 "classpath*:com/chariot/quizzo/web/EngineControllerTest-context.xml"})
public class EngineControllerTest {

    @Autowired
    ApplicationContext context;

    EngineController controller;

    @Before
    public void setUp() {
        controller.setQuizGenerator(
                context.getBean(QuizGenerator.class));

        controller.setStateMachine(context.getBean(QuizRunStateMachine.class));
    }

    @Test
    public void testContext() {
        Assert.assertNotNull(context);
    }



}
