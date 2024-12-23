package model;
import java.sql.*;

public class Database {

    private Connection conn;

    //Constructor
    Database() {
        String url ="jdbc:sqlite:essence_and_care_database.db";

        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to Essence&Care database");

        } catch (Exception e){
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if(conn == null){
            System.out.println("Getting Connection to Database failed");
            return null;
        }
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection");
        }
    }

    public static void main(String[] args) {
        Database db = new Database();
        db.getConnection();
        db.closeConnection();
    }
}
