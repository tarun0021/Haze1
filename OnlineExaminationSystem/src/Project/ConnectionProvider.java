/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;
import java.sql.*;
import java.sql.Connection;

/**
 *
 * @author tk801
 */
public class ConnectionProvider {
    public static Connection getcon()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oems","root","trilok@1234567890");
            return con;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
}
