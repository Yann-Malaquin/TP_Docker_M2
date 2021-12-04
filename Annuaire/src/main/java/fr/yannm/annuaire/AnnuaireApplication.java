package fr.yannm.annuaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class AnnuaireApplication {

    public static void main(String[] args) {

        Connection con = null;

        try {
            //Registering the HSQLDB JDBC driver
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            //Creating the connection with HSQLDB
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/test", "sa", "");
            if (con != null) {
                System.out.println("Connection created successfully");

            } else {
                System.out.println("Problem with creating connection");
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        SpringApplication.run(AnnuaireApplication.class, args);
    }

}
