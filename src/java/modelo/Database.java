
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/jjs service";
    private String usuario = "root";
    private String contraseña = "";
    private Connection con;

    public Database() {
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error"+e);
        }
    }

    public Connection getConnection(){
        return con;
    }
}
