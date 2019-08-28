package com.apsidepoei.projetpoeitest.restTest;

import java.io.IOException;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.AssessmentRepository;
import com.apsidepoei.projetpoei.entities.Assessment;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class AssessmentRestControllerTest extends BaseRestControllerTest<Assessment, Integer> {

  @Autowired
  private AssessmentRepository repository;

  public AssessmentRestControllerTest() {
    super("/assessments");
  }

  @Override
  protected JpaRepository<Assessment, Integer> getRepository() {
    return repository;
  }

  @Override
  protected List<Assessment> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Assessment>>() {
    });
  }

  @Override
  protected boolean compareTo(Assessment item1, Assessment item2) {
    return item1.getId().equals(item2.getId()) && item1.getCategory().equals(item2.getCategory())
        && item1.getDateTime().compareTo(item2.getDateTime()) == 0;
  }
}