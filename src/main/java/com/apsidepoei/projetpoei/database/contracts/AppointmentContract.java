package com.apsidepoei.projetpoei.database.contracts;

/**
 * This class is the Appointment contract.
 *
 * @author thomas
 *
 */
public class AppointmentContract extends BaseContract {

  /**
   * Define the table name.
   */
  public static final String TABLE = "appointment";
  /**
   * defines the name of the column="id_appointment".
   */
  public static final String COL_ID = "id_appointment";
  /**
   * defines the name of the column="appointment_type".
   */
  public static final String COL_APPOINTMENT_TYPE = "appointment_type";
  /**
   * defines the name of the column="informations".
   */
  public static final String COL_INFORMATIONS = "informations";
  /**
   * defines the name of the column="appointment_date".
   */
  public static final String COL_APPOINTMENTDATE = "appointment_date";
  /**
   * defines the name of the column="report".
   */
  public static final String COL_REPORT = "report";
  /**
   * defines the name of the column="status".
   */
  public static final String COL_STATUS = "status";
  /**
   * defines the name of the column="persons".
   */
  public static final String COL_PERSONS = "persons";

  /**
   * defines the name of the column="organizer".
   */
  public static final String COL_ORGANIZER = "organizer";

  /**
   * Define a table with all column.
   */
  public static final String[] COLS = new String[] {
      COL_ID, COL_INFORMATIONS, COL_APPOINTMENTDATE, COL_REPORT
  };

  /**
   * Define the string used for create the table.
   */
  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_INFORMATIONS + " VARCHAR(255),"
      + COL_APPOINTMENTDATE + " DATETIME NOT NULL," + COL_REPORT + " TEXT" + ")";

  /**
   * Constructor.
   */
  public AppointmentContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
