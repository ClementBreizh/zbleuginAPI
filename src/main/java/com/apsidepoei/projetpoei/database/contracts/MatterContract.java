package com.apsidepoei.projetpoei.database.contracts;

public class MatterContract extends BaseContract {

  /**
   * Define the table name.
   */
  public static final String TABLE = "matter";

  /**
   * defines the name of the column="id_matter".
   */
  public static final String COL_ID = "id_matter";
  /**
   * defines the name of the column="name".
   */
  public static final String COL_NAME = "name";
  /**
   * defines the name of the column="candidates".
   */
  public static final String COL_CANDIDATES = "candidates";


  public static final String[] COLS = new String[] { COL_ID, COL_NAME };

  public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + "(" + COL_ID
      + " int NOT NULL AUTO_INCREMENT PRIMARY KEY," + COL_NAME + " VARCHAR(50) NOT NULL" + ")";

  /**
   * Constructor.
   */
  public MatterContract() {
    super(TABLE, COL_ID, COLS, CREATE_TABLE);
  }
}
