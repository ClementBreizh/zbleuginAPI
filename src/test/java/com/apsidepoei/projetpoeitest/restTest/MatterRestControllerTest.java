/*
package com.apsidepoei.projetpoeitest.restTest;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.MatterRepository;
import com.apsidepoei.projetpoei.entities.Matter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

*/
/**
 *
 * @author clemb Tests for Matter Entity.
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class MatterRestControllerTest extends BaseRestControllerTest<Matter, Integer> {

  @Autowired
  private MatterRepository repository;

  */
/**
   * Empty Constructor.
   *//*

  public MatterRestControllerTest() {
    super("/matters");
  }

  */
/**
   * Create repository.
   *//*

  @Override
  protected JpaRepository<Matter, Integer> getRepository() {
    return repository;
  }

  */
/**
   * Parse Json to List for test.
   *//*

  @Override
  protected List<Matter> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<List<Matter>>() {
    });
  }

  */
/**
   * Compare if data is the same.
   *//*

  @Override
  protected boolean compareTo(Matter item1, Matter item2) {
    return item1.getId().equals(item2.getId()) && item1.getName().equals(item2.getName());
  }

  */
/**
   * Parse Json to a Object for run test.
   *//*

  @Override
  protected Matter parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Matter>() {
    });
  }

  */
/**
   * Generate a Id for run test.
   *//*

  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  */
/**
   * Create a object for run test.
   *//*

  @Override
  protected Matter getObjectTest() throws ParseException {
    Matter item = new Matter("MatièreTest1");
    return item;
  }

  */
/**
   * Return Id of Object for run test.
   *//*

  @Override
  protected Integer getItemIdTest(Matter item) {
    return item.getId();
  }

  */
/**
   * Create a string for POST method API.
   *//*

  @Override
  protected String getObjectToStringToPost() {
    String urlParameters = "name=MatièreTest1";
    return urlParameters;
  }

  */
/**
   * Method to compare list.
   *//*

  @Override
  protected boolean compareToList(List<Matter> items, List<Matter> dbItems) {
    return false;
  }

  */
/**
   * Test to getAll.
   *
   * @throws IOException
   *//*

  @Test
  public void getAll() throws IOException {
    StringBuilder builder = new StringBuilder();
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath, HttpMethod.GET);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }

    List<Matter> dbItems = getRepository().findAll();
    List<Matter> httpItems = parseJsonToList(builder);

    if (dbItems.size() != httpItems.size()) {
      fail("List sized are not same");
    }
    for (int i = 0; i < httpItems.size(); i++) {
      if (!compareTo(dbItems.get(i), httpItems.get(i))) {
        fail();
      }
    }
  }

  */
/**
   * Test to getById.
   *
   * @throws IOException
   * @throws ParseException
   *//*

  @Test
  public void getById() throws IOException, ParseException {
    StringBuilder builder = new StringBuilder();
    Matter item = getRepository().save(getObjectTest());
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath + "/" + getItemIdTest(item), HttpMethod.GET);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }

    Optional<Matter> dbItem = getRepository().findById(getItemIdTest(item));

    Matter httpItem = parseJsonToObject(builder);

    if (dbItem == null && httpItem == null) {
      fail("One of object is null");
    }

    if (!compareTo(dbItem.get(), httpItem)) {
      fail();
    }

  }

  */
/**
   * Test if data is deleted.
   *
   * @throws IOException
   * @throws ParseException
   *//*

  @Test(expected = NoSuchElementException.class)
  public void deleteById() throws IOException, ParseException {
    StringBuilder builder = new StringBuilder();
    Matter item = getRepository().save(getObjectTest());
    getRepository().flush();
    try {
      httpUtils.callServer(builder, BASE_API + entityPath + "/" + getItemIdTest(item), HttpMethod.DELETE);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
    Optional<Matter> deleteItem = getRepository().findById(getItemIdTest(item));
    deleteItem.get();
  }

  */
/**
   * Test if table is clear
   *
   * @throws IOException
   *//*

  @Test
  public void deleteAll() throws IOException {
    StringBuilder builder = new StringBuilder();
    try {
      builder = httpUtils.callServer(builder, BASE_API + entityPath, HttpMethod.DELETE);
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
    List<Matter> httpItems = parseJsonToList(builder);

    if (!httpItems.isEmpty()) {
      fail();
    }
  }

  */
/**
   * Test if size of item is the same
   *
   * @throws IOException
   *//*

  @Test
  public void count() throws IOException {
    StringBuilder builder = new StringBuilder();
    builder = httpUtils.callServer(builder, BASE_API + entityPath, HttpMethod.GET);

    List<Matter> dbItems = getRepository().findAll();
    List<Matter> httpItems = parseJsonToList(builder);
    if (dbItems.size() != httpItems.size()) {
      fail();
    }
  }

  */
/**
   * Test for save objet, get him to URL + repo and test if is the same.
   * @throws Exception
   *//*

  @Test
  public void save() throws Exception {
    getRepository().deleteAll();
    String objJson = this.objectMapper.writeValueAsString(getObjectTest());

    // Prepare Request
    MockHttpServletRequestBuilder request = post(BASE_API + entityPath + "/test").contentType("application/json")

        .content(objJson);

    MvcResult result = this.mockMvc.perform(request).andExpect(status().isOk()).andReturn();

    System.out.println(result.getResponse().getStatus());
    System.out.println(result.getResponse().getContentAsString());

    // Transform to Object
    Matter item = parseJsonToObject(new StringBuilder(result.getResponse().getContentAsString()));

    Optional<Matter> dbItem = getRepository().findById(getItemIdTest(item));

    if (dbItem == null && item == null) {
      fail("One of object is null");
    }

    if (!compareTo(dbItem.get(), item)) {
      fail();
    }
  }
}
*/
