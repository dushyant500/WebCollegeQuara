/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CollegeQuara.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dushyant
 */
public class DBConnection {
 public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
    Class.forName("com.mysql.jdbc.Driver");
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegequera","root","root");
        return cnn;
    }   
}
