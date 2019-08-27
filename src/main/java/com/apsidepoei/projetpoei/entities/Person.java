/**
 *
 */
package com.apsidepoei.projetpoei.entities;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.apsidepoei.projetpoei.database.contracts.PersonContract;
import com.apsidepoei.projetpoei.entities.Appointment;
/**
 * @author vianney
 *
 */
@Entity
@Table(name = PersonContract.TABLE)
@AttributeOverride(name = "id_person", column = @Column(name=PersonContract.COL_ID))
public class Person extends EntityDb {

  private String firstname;
  private String lastname;
  private String email;
  private String cellPhone;
  private String homePhone;
  private String commentary;
  @ManyToMany
  private List<Appointment> appointments;

  /**
   * @return the firstname
   */
  public String getFirstname() {
    return firstname;
  }
  /**
   * @param firstname the firstname to set
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  /**
   * @return the lastname
   */
  public String getLastname() {
    return lastname;
  }
  /**
   * @param lastname the lastname to set
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * @return the cellPhone
   */
  public String getCellPhone() {
    return cellPhone;
  }
  /**
   * @param cellPhone the cellPhone to set
   */
  public void setCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
  }
  /**
   * @return the homePhone
   */
  public String getHomePhone() {
    return homePhone;
  }
  /**
   * @param homePhone the homePhone to set
   */
  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }
  /**
   * @return the commentary
   */
  public String getCommentary() {
    return commentary;
  }
  /**
   * @param commentary the commentary to set
   */
  public void setCommentary(String commentary) {
    this.commentary = commentary;
  }
}