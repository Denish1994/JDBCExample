
package denish.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
    public static Connection getConnection() throws Exception{
        Properties pro = new Properties();
        pro.load(new FileInputStream("DBConfig.properties"));
        String conUrl = pro.getProperty("conUrl");
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        
        Connection con = DriverManager.getConnection(conUrl, user,password);
        con.setAutoCommit(true);
        System.out.println("Connected....");
        return con;
    }
    
    public static void main (String args[]) throws Exception {
        getConnection();
    }
}
