/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package database;
import java.sql.*;
import java.util.HashMap;

/**
 *
 * @author mynguyen
 */
public class MyConnectionInit {
    private MySQLConnection connect;

    public MyConnectionInit() {
        connect = new MySQLConnection("localhost", "root", "", "QlyNhaThuoc");
    }

    public MyConnectionInit(String host, String username, String password, String database) {
        connect = new MySQLConnection(host, username, password, database);
    }
    
    // Select with orderby
    public ResultSet select(String tablename, String condition, String orderBy) throws Exception {
        StringBuilder query = new StringBuilder("SELECT * FROM " + tablename);
        
        this.addCondition(query, condition);
        
        this.addOrderBy(query, orderBy);
        
        query.append(";");
        
        return this.connect.executeQuery(query.toString());
    }
    
    public ResultSet select(String tablename, String condition) throws Exception {
        return this.select(tablename, condition, null);
    }
    
    public boolean insert(String tablename, HashMap<String, Object> columnValues) throws Exception {
        StringBuilder query = new StringBuilder("INSERT INTO " + tablename);
        
        StringBuilder valueInsert = new StringBuilder();
        
        query.append("(");
        
        for (String key : columnValues.keySet()) {
            query.append(key + ",");
            valueInsert.append("'" + columnValues.get(key).toString() + "',");
        }
        
        query = query.delete(query.length() - 1, query.length());
        valueInsert = valueInsert.delete(valueInsert.length() - 1, valueInsert.length());
        
        query.append(") VALUES (" + valueInsert.toString() + ")");
        
        query.append(";");
        
        return this.connect.executeUpdate(query.toString()) > 0;
    }
    
    public boolean update(String tablename, HashMap<String, Object> columnValues, String condition) throws Exception {
        StringBuilder query = new StringBuilder("UPDATE " + tablename + " SET ");
        
        for (String key : columnValues.keySet()) {
            query.append(key + " = '" + columnValues.get(key).toString() + "', ");
        }
        
        query = query.delete(query.length() - 2, query.length());
        
        this.addCondition(query, condition);
        
        query.append(";");
        System.out.println(query);
        return this.connect.executeUpdate(query.toString()) > 0;
    }
    
    public boolean delete(String tablename, String condition) throws Exception {
        StringBuilder query = new StringBuilder("DELETE FROM " + tablename);
        
        this.addCondition(query, condition);
        
        return this.connect.executeUpdate(query.toString()) > 0;
        
    }
    
    public boolean delete(String tablename, String condition1, String condition2) throws Exception {
        StringBuilder query = new StringBuilder("DELETE FROM " + tablename);
        
        this.addCondition(query, condition1, condition2);
        
        return this.connect.executeUpdate(query.toString()) > 0;
        
    }
    
    private void addCondition(StringBuilder query, String condition) {
        if (condition != null) {
            query.append(" WHERE " + condition);
        }
    }
    
    private void addCondition(StringBuilder query, String condition1, String condition2){
        if(condition1 != null   &&   condition2 != null){
            query.append(" WHERE " + condition1 + " AND " + condition2);
        }
    }
    
    private void addOrderBy(StringBuilder query, String orderBy) {
        if (orderBy != null) {
            query.append(" ORDER BY " + orderBy);
        }
    }
    
    public void Close() throws SQLException {
        this.connect.Close();
    }
}
