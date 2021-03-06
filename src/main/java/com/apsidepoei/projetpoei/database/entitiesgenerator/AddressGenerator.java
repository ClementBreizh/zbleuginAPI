//package com.apsidepoei.projetpoei.database.entitiesgenerator;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Address;
//import com.github.javafaker.Faker;
//import com.tactfactory.consolelogger.ConsoleLogger;
//import com.tactfactory.consolelogger.Options;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
///**
// * This class generate fake data for Address class.
// *
// * @author vianney
// */
//public class AddressGenerator {
//
//  /**
//   * Constructor.
//   */
//  private AddressGenerator() {
//  }
//
//  private static AddressGenerator INSTANCE = null;
//
//  /**
//   * Instance of the constructor.
//   * @return an instance.
//   */
//  public static AddressGenerator getInstance() {
//    if (INSTANCE == null) {
//      synchronized (AddressGenerator.class) {
//        if (INSTANCE == null) {
//          INSTANCE = new AddressGenerator();
//        }
//      }
//    }
//    return INSTANCE;
//  }
//
//  Faker faker = new Faker(Locale.FRENCH);
//  private List<Address> datas = new ArrayList<Address>();
//
//  /**
//   * Generate fake data.
//   *
//   * @return fake data
//   */
//  public List<Address> generateDatas() throws SQLException {
//    return generateDatas(faker.random().nextInt(100));
//  }
//
//  /**
//   * Generate n fake data.
//   *
//   * @param nb = the number.
//   * @return n fake data
//   */
//  public List<Address> generateDatas(int nb) throws SQLException {
//    List<Address> result = new ArrayList<>();
//    List<String> addresses = new ArrayList<String>();
//
//    int i = 0;
//    while (i < nb) {
//      String postalAddress = faker.address().streetAddress();
//      String postalCode = faker.address().zipCode();
//      String town = faker.address().city();
//
//      if (!addresses.contains(postalAddress)) {
//        addresses.add(postalAddress);
//
//        Address address = new Address(postalAddress, postalCode, town);
//        result.add(address);
//
//        i++;
//      }
//    }
//    return result;
//  }
//
//  /**
//   * Generate and insert datas.
//   */
//  public void generateAndInsertDatas() throws SQLException {
//    generateAndInsertDatas(faker.random().nextInt(100));
//  }
//
//  /**
//   * Generate and insert n datas.
//   *
//   * @param nb = the number.
//   */
//  public void generateAndInsertDatas(int nb) throws SQLException {
//    for (Address address : generateDatas(nb)) {
//      DbManager.getInstance().getAddressDao().insert(address);
//      System.out.println(address);
//      datas.add(address);
//    }
//  }
//
//  /**
//   * Drop, create table, generate and insert datas.
//   *
//   */
//  public void generateAndInsertDatasDroppingTable() throws SQLException {
//    generateAndInsertDatasDroppingTable(faker.random().nextInt(100));
//  }
//
//  /**
//   * Drop, create table, generate and insert n data.
//   *
//   * @param nb = number
//   */
//  public void generateAndInsertDatasDroppingTable(int nb) throws SQLException {
//    ConsoleLogger generatedLogger = new ConsoleLogger("Address generated data tests",
//        Options.DEBUG);
//    generatedLogger.Log("Lancement des tests de données générées.", Options.DEBUG);
//
//    DbManager.getInstance().getAddressDao().drop();
//    DbManager.getInstance().getAddressDao().create();
//
//    generateAndInsertDatas(nb);
//
//    generatedLogger.Log("Fin des tests de données générées.", Options.DEBUG);
//  }
//
//  /**
//   * Delete datas.
//   */
//  public void deleteDatas() {
//    for (Address address : datas) {
//      DbManager.getInstance().getAddressDao().delete(address);
//    }
//  }
//}
