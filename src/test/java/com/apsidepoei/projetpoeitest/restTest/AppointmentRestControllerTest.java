package com.apsidepoei.projetpoeitest.restTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpMethod;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.apsidepoei.projetpoei.ZbleuginApplication;
import com.apsidepoei.projetpoei.database.repositories.AppointmentRepository;
import com.apsidepoei.projetpoei.database.repositories.PersonRepository;
import com.apsidepoei.projetpoei.entities.Appointment;
import com.apsidepoei.projetpoei.entities.AppointmentType;
import com.apsidepoei.projetpoei.entities.Matter;
import com.apsidepoei.projetpoei.entities.Person;
import com.apsidepoei.projetpoei.entities.Session;
import com.apsidepoei.projetpoeitest.utils.RestResponsePage;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author clemb Tests for Appointment Entity.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ZbleuginApplication.class)
public class AppointmentRestControllerTest extends BaseRestControllerTest<Appointment, Integer> {

  @Autowired
  private AppointmentRepository repository;


  @Autowired
  private PersonRepository personrepo;

  /**
   * Empty Constructor.
   */
  public AppointmentRestControllerTest() {
    super("/appointments");
  }

  /**
   * Create repository.
   */
  @Override
  protected JpaRepository<Appointment, Integer> getRepository() {
    return repository;
  }

  /**
   * Parse Json to List for test.
   * @throws IOException
   * @throws JsonMappingException
   * @throws JsonParseException
   */
  @Override
  protected List<Appointment> parseJsonToList(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    return this.parseJsonToList(builder.toString());
  }

  /**
   * Parse Json to List for test.
   */
  protected List<Appointment> parseJsonToList(String content)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    RestResponsePage<Appointment> pAppointment = mapper.readValue(content, new TypeReference<RestResponsePage<Appointment>>() {});

    return pAppointment.getContent();
  }

  /**
   * Compare if data is the same.
   */
  @Override
  protected boolean compareTo(Appointment item1, Appointment item2) {
    return item1.getId().equals(item2.getId()) && item1.getInformations().equals(item2.getInformations())
        && item1.getAppointmentDate().compareTo(item2.getAppointmentDate()) == 0
        && item1.getReport().equals(item2.getReport());
  }

  /**
   * Parse Json to a Object Appointment for run test.
   */
  @Override
  protected Appointment parseJsonToObject(StringBuilder builder)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(builder.toString(), new TypeReference<Appointment>() {
    });
  }

  /**
   * Generate a Id for run test.
   */
  @Override
  protected Integer getItemIdToTest() {
    return 1;
  }

  /**
   * Create a object for run test.
   */
  LocalDateTime date = LocalDateTime.now();
  Person organizer = new Person();

  @Override
  protected Appointment getObjectTest() throws ParseException {

    Appointment item = new Appointment(date, organizer, AppointmentType.TYPE_0);

    return item;
  }

  /**
   * Return Id of Object for run test.
   */
  @Override
  protected Integer getItemIdTest(Appointment item) {
    return item.getId();
  }

  /**
   * Create a string for POST method API.
   */
  @Override
  protected String getObjectToStringToPost() {
    String urlParameters = "informations=Commentaire&dateTime=2019/12/15&report=Report";
    return urlParameters;
  }

  /**
   * Method to compare list.
   */
  @Override
  protected boolean compareToList(List<Appointment> items, List<Appointment> dbItems) {
    return false;
  }

  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void setup() {
    mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
  }

  /**
   * Test function via HTTP
   *
   * @throws Exception
   */
  @WithMockUser(username = "admin", password = "adminadmin")
  @Test
  public void test() throws Exception {

    // Make objects
    Person pers = personrepo.findById(getItemIdToTest()).get();

    AppointmentType type = AppointmentType.TYPE_1;

    Appointment sess = new Appointment();
    sess.setAppointmentDate(LocalDateTime.now());
    sess.setOrganizer(pers);
    sess.setAppointmentType(type);

    // Transform to JSON
    String objJson = this.objectMapper.writeValueAsString(sess);

    // Prepare Request
    MockHttpServletRequestBuilder request = post(BASE_API + entityPath + "/test").contentType("application/json")

        .content(objJson);

    MvcResult result = this.mockMvc.perform(request).andExpect(status().isOk()).andReturn();

    System.out.println(result.getResponse().getStatus());
    System.out.println(result.getResponse().getContentAsString());

    // Transform to Object
    Appointment newSess = this.objectMapper.readValue(result.getResponse().getContentAsString(), Appointment.class);

    // Tests
    assertNotNull(newSess);
    assertThat(sess.getAppointmentDate()).isEqualTo(newSess.getAppointmentDate());
  }
//  @WithMockUser(username="admin",password="adminadmin")
//  @Test
//  public void getTest() throws Exception {
//
//    MockHttpServletRequestBuilder getresult = get(BASE_API + entityPath).contentType("application/json");
//
//    List<Appointment> result = parseJsonToList(this.mockMvc.perform(getresult).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
//   // MvcResult result = this.mockMvc.perform(getresult).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//    System.out.println("http = " + result);
//    List<Appointment> dbItems = getRepository().findAll();
//    System.out.println("DB = " + dbItems);
//
//    // Tests
//    assertTrue(compareToList(result, dbItems));
//
//  }
}
