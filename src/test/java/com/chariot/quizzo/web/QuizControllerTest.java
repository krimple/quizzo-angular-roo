package com.chariot.quizzo.web;

import com.chariot.quizzo.model.Question;
import com.chariot.quizzo.model.Quiz;
import flexjson.JSONDeserializer;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

// for the MVC test DSL
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@ActiveProfiles(profiles = {"integration"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/webmvc-config.xml",
    "classpath:/META-INF/spring/applicationContext.xml"})
public class QuizControllerTest {


  @Autowired
  WebApplicationContext context;

  MockMvc mvc;

  private JSONDeserializer<HashMap<String, String>> deserializer = null;

  @Before
  public void setUp() {
    mvc = webAppContextSetup(this.context).build();
    deserializer = new JSONDeserializer<HashMap<String, String>>();
  }

  @Test
  public void testContext() {
    Assert.assertNotNull(context);
  }

  @Test
  public void testEntityCount() {
    assertEquals(1, Quiz.countQuizzes());
    assertEquals(2, Question.countQuestions());
  }


}
