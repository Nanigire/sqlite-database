package com.example.kvanamacair4.asynctask.model;

public class User {

    public static String DATABASE_NAME = "UserDataBase";

    public static final String TABLE_NAME = "UserTable";

    public static String Table_Column_ID = "";

    public static String Table_Column_1_Name = "name";

    public static String Table_Column_2_Email = "email";

    public static String Table_Column_3_Password = "password";

    private int id;
    private String name;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + Table_Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + Table_Column_1_Name + "VARCHAR,"
                    + Table_Column_2_Email + "VARCHAR,"
                    + Table_Column_3_Password + "VARCHAR"
                    + ")";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getTable_Column_ID() {
        return Table_Column_ID;
    }

    public static void setTable_Column_ID(String table_Column_ID) {
        Table_Column_ID = table_Column_ID;
    }

    public static String getTable_Column_1_Name() {
        return Table_Column_1_Name;
    }

    public static void setTable_Column_1_Name(String table_Column_1_Name) {
        Table_Column_1_Name = table_Column_1_Name;
    }

    public static String getTable_Column_2_Email() {
        return Table_Column_2_Email;
    }

    public static void setTable_Column_2_Email(String table_Column_2_Email) {
        Table_Column_2_Email = table_Column_2_Email;
    }

    public static String getTable_Column_3_Password() {
        return Table_Column_3_Password;
    }

    public static void setTable_Column_3_Password(String table_Column_3_Password) {
        Table_Column_3_Password = table_Column_3_Password;
    }

    public static String getCreateTable() {
        return CREATE_TABLE;
    }
}
