package com.chariot.quizzo.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = { "classpath:META-INF/spring/applicationContext.xml",
                                    "classpath:META-INF/spring/applicationContext-testdatasetup.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ModelIT {

  @Test
  public void testSomething() {
    Assert.assertTrue(1 == 1);
  }
}