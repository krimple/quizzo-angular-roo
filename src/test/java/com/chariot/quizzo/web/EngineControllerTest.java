package com.chariot.quizzo.web;

import com.chariot.quizzo.engine.QuizGenerator;
import com.chariot.quizzo.engine.QuizRunStateMachine;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextConfigurationAttributes;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
 "classpath*:/META-INF/spring/applicationContext*.xml"})
public class EngineControllerTest {

    ApplicationContext context;

    private EngineController controller;

    @Before
    public void setUp() {
        System.setProperty("spring.profiles.active", "development");
        context = new ClassPathXmlApplicationContext(
          "classpath:/META-INF/spring/applicationContext.xml"

        );

        controller = new EngineController();
        controller.setQuizGenerator(
                context.getBean(QuizGenerator.class));

        controller.setStateMachine(context.getBean(QuizRunStateMachine.class));
    }

    @Test
    public void testContext() {
        Assert.assertNotNull(context);
    }

    @Test
    public void tryStartQuiz() {
        MockHttpSession session = new MockHttpSession();
        String result = controller.startQuizRun("Joey", session);

        Assert.assertNotNull(session.getAttribute("quizId"));
        Assert.assertNotNull(session.getAttribute("playerKey"));


    }


}
