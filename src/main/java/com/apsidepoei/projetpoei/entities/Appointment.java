package com.apsidepoei.projetpoei.entities;

import com.apsidepoei.projetpoei.database.contracts.AppointmentContract;
import com.apsidepoei.projetpoei.database.contracts.PersonContract;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * This class is the Appointment entity.
 *
 * @author thomas
 *
 */
@Entity
@ToString
@Table(name = AppointmentContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = AppointmentContract.COL_ID))
public class Appointment extends EntityDb {

  @Column(name = AppointmentContract.COL_APPOINTMENTDATE, nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private LocalDateTime appointmentDate;

  @Column(name = AppointmentContract.COL_APPOINTMENT_TYPE, nullable = false)
  private AppointmentType appointmentType;

  @Column(name = AppointmentContract.COL_INFORMATIONS, nullable = true)
  private String informations;

  @Column(name = AppointmentContract.COL_REPORT, nullable = true)
  private String report;

  @Column(name = AppointmentContract.COL_STATUS)
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean status = false;

  @ManyToMany(targetEntity = Person.class)
  @JoinTable(name = "appointment_persons", joinColumns = {
      @JoinColumn(name = AppointmentContract.COL_ID) }, inverseJoinColumns = {
          @JoinColumn(name = PersonContract.COL_ID) })
  @JsonIgnoreProperties({"appointments"})
  private List<Person> persons;

  @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
  @JoinColumn(name = AppointmentContract.COL_ORGANIZER,
      referencedColumnName = PersonContract.COL_ID, nullable = false)
  @Lazy(value = true)
  @JsonIgnoreProperties({"appointments"})
  private Person organizer;

  /**
   * Empty constructor.
   */
  public Appointment() {
    super();
    this.persons = new ArrayList<Person>();
  }

  /**
   * Constructor with only associations.
   * @param appointmentDate is the date of the appointment.
   * @param organizer is the organizer.
   * @param appointmentType is the type.
   */
  public Appointment(LocalDateTime appointmentDate,
                     Person organizer, AppointmentType appointmentType) {
    super();
    this.appointmentDate = appointmentDate;
    this.organizer = organizer;
    this.appointmentType = appointmentType;
    this.persons = new ArrayList<Person>();
  }

  /**
   * Constructor  with  non null informations.
   * @param informations is the informations of this appointment.
   * @param appointmentType is the type.
   * @param appointmentDate is the date.
   * @param report is the comment after the appointment.
   * @param status is the status of the appointment.
   */
  public Appointment(String informations, LocalDateTime appointmentDate, String report,
      Boolean status, Person organizer, AppointmentType appointmentType) {
    super();
    this.informations = informations;
    this.appointmentDate = appointmentDate;
    this.appointmentType = appointmentType;
    this.report = report;
    this.status = status;
    this.organizer = organizer;
    this.persons = new ArrayList<Person>();
  }

  /**
   * Constructor with all informations.
   * @param informations is the informations of this appointment.
   * @param appointmentType is the type.
   * @param appointmentDate is the date.
   * @param report is the comment after the appointment.
   * @param status is the status of the appointment.
   * @param persons is a list of guests.
   * @param organizer is the organizer.
   */
  public Appointment(String informations, LocalDateTime appointmentDate, String report,
      Boolean status, List<Person> persons, Person organizer, AppointmentType appointmentType) {
    super();
    this.informations = informations;
    this.appointmentType = appointmentType;
    this.appointmentDate = appointmentDate;
    this.report = report;
    this.status = status;
    this.persons = persons;
    this.organizer = organizer;
  }

  // GETTER/SETTER
  /**
   * The informations.
   *
   * @return the informations.
   */
  public String getInformations() {
    return informations;
  }

  /**
   * Set the informations.
   *
   * @param informations = the informations.
   */
  public void setInformations(String informations) {
    this.informations = informations;
  }

  /**
   * Return the dateTime.
   *
   * @return the dateTime.
   */
  public LocalDateTime getAppointmentDate() {
    return appointmentDate;
  }

  /**
   * Set the dateTime.
   *
   * @param appointmentDate = the date and time
   */
  public void setAppointmentDate(LocalDateTime appointmentDate) {
    this.appointmentDate = appointmentDate;
  }

  /**
   * The report.
   *
   * @return the report.
   */
  public String getReport() {
    return report;
  }

  /**
   * Set the report.
   *
   * @param report = the report
   */
  public void setReport(String report) {
    this.report = report;
  }

  /**
   * Return the status for this appointment.
   * @return a boolean for the status.
   */
  public Boolean getStatus() {
    return status;
  }

  /**
   * Set the status for this appointment.
   * @param status is the status for the appointment.
   */
  public void setStatus(Boolean status) {
    this.status = status;
  }

  /**
   * Getter fot the persons list in this appointment.
   * @return a list of persons.
   */
  public List<Person> getPersons() {
    return persons;
  }

  /**
   * Add a person to the giests list.
   * @param person is a guest a the appointment.
   */
  public void addPerson(Person person) {
    if (!this.persons.contains(person)) {
      this.persons.add(person);
    }
  }

  /**
   * Setter for the persons list.
   * @param persons is a list of persons, concerned in this appointment.
   */
  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }

  public Person getOrganizer() {
    return organizer;
  }

  public void setOrganizer(Person organizer) {
    this.organizer = organizer;
  }

  /**
   * Return the type.
   * @return the appointmentType.
   */
  public AppointmentType getAppointmentType() {
    return appointmentType;
  }

  /**
   * Setter for the type.
   * @param appointmentType the appointmentType to set.
   */
  public void setAppointmentType(AppointmentType appointmentType) {
    this.appointmentType = appointmentType;
  }

}
