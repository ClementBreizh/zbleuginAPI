package com.apsidepoei.projetpoei.entities;

import com.apsidepoei.projetpoei.database.contracts.AddressContract;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.ToString;

/**
 * This class is the Address entity.
 * @author vianney
 *
 */
@Entity
@ToString
@Table(name = AddressContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name = AddressContract.COL_ID))
public class Address extends EntityDb {

  @Column(name = AddressContract.COL_STREET, nullable = false)
  private String street;

  @Column(name = AddressContract.COL_POSTAL_CODE, nullable = false, length = 5)
  private String postalCode;

  @Column(name = AddressContract.COL_CITY, nullable = false)
  private String city;


  /**
   * Empty constructor.
   */
  public Address() {
    super();
  }

  /**
   * Constructor with id for new Address.
   *
   * @param street    = the street
   * @param postalCode = the postalCode
   * @param city       = the city
   */
  public Address(String street, String postalCode, String city) {
    super();
    this.street = street;
    this.postalCode = postalCode;
    this.city = city;
  }


  // GETTER/SETTER

  /**
   * The street.
   *
   * @return the street
   */
  public String getStreet() {
    return street;
  }

  /**
   * Set the street.
   *
   * @param street = the street
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * The postalCode.
   *
   * @return the postal code
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * Set the postalCode.
   *
   * @param postalCode = the postalCode
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  /**
   * The city.
   *
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * Set the city.
   *
   * @param city = the city
   */
  public void setCity(String city) {
    this.city = city;
  }

}
