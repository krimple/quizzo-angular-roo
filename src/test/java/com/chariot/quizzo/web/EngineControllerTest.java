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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextConfigurationAttributes;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.web.WebMergedContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

@ActiveProfiles(profiles = {"development"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/META-INF/spring/applicationContext*.xml"})
public class EngineControllerTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    MockMvc mvc;

//    @Before
//    public void setUp() {
//        controller = new EngineController();
//        controller.setQuizGenerator(
//                context.getBean(QuizGenerator.class));
//
//        controller.setStateMachine(context.getBean(QuizRunStateMachine.class));
//    }

    @Test
    public void testContext() {
        Assert.assertNotNull(context);
    }

    @Test
    public void tryStartQuiz() {
        this.mvc.perform(get(""))
        MockHttpSession session = new MockHttpSession();
        String result = controller.startQuizRun("Joey", session);

        Assert.assertNotNull(session.getAttribute("quizId"));
        Assert.assertNotNull(session.getAttribute("playerKey"));


    }


}
