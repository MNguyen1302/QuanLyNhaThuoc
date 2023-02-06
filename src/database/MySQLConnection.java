/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package database;

import java.sql.*;
import java.util.TimeZone;

/**
 *
 * @author mynguyen
 */

public class MySQLConnection {
    String host = "";
    String username = "";
    String password = "";
    String database = "";
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public MySQLConnection(String host, String username, String password, String database) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.database = database;
    }
    
    protected void driveTest () throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            throw new Exception("My SQL not found driveTest");
        }
        
    }
    
    protected Connection getConnection() throws Exception {
        if (this.conn == null) {
            driveTest();
            
            String url = "jdbc:mysql://" + this.host + ":3306/" + this.database + "?serverTimezone=" + TimeZone.getDefault().getID();
            
            try {
                this.conn = (Connection) DriverManager.getConnection(url, this.username, this.password);
            } catch (Exception e) {
                throw new Exception("không thể kết nối tới Database" + url + e.getMessage());
            }
        }
        return this.conn;        
    }
    
    protected Statement getStatement() throws Exception {
        if (this.stmt == null) {
            this.stmt = getConnection().createStatement();
        } else {
            this.stmt.isClosed();
        }
        return this.stmt;
    }

    public ResultSet executeQuery(String query) throws Exception {
        try {
            this.rs = getStatement().executeQuery(query);
        } catch (Exception e) {
            throw new Exception("Error" + e.getMessage());
        }
        
        return this.rs;
    }
    
    public int executeUpdate(String query) throws Exception {
        int result = Integer.MIN_VALUE;

        try {
            result = getStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new Exception("Error" + e.getMessage());
        }
        
        return result;
    }
    
    public void Close() throws SQLException {
        if (this.rs != null && this.rs.isClosed()) {
            this.rs.close();
            this.rs = null;
        }
        if (this.stmt != null && this.stmt.isClosed()) {
            this.stmt.close();
            this.stmt = null;
        }
        if (this.conn != null && this.conn.isClosed()) {
            this.conn.close();
            this.conn = null;
        }
    }

    int executeUpdate(StringBuilder query) {
        return 0;
    }
}  
