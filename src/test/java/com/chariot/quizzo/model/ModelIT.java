package com.chariot.quizzo.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static junit.framework.Assert.assertEquals;

@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext.xml",
                                    "classpath*:META-INF/spring/applicationContext-testdatasetup.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ModelIT {

  @Autowired
  private DataSource dataSource;

  @Test
  public void testSomething() {
    JdbcTemplate template = new JdbcTemplate(dataSource);
    assertEquals(3, template.queryForInt("select count(*) from Quiz"));
    assertEquals(1, template.queryForInt("select min(id) from Quiz"));
    assertEquals(3, template.queryForInt("select max(id) from Quiz"));
  }
}