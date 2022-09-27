package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;

import java.sql.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String database = "bookish";
        String user = "gparle";
        String password = "gparle";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

        jdbcMethod(connectionString);
        jdbiMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {
        System.out.println("JDBC method...");

        // TODO: print out the details of all the books (using JDBC)
        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

        Connection connection = DriverManager.getConnection(connectionString);
        String query = "SELECT * FROM bookish.Books";
        try {
            Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(query);
        System.out.println(rs);
        while (rs.next()) {
            String title = rs.getString("title");
//            int supplierID = rs.getInt("SUP_ID");
//            float price = rs.getFloat("PRICE");
//            int sales = rs.getInt("SALES");
//            int total = rs.getInt("TOTAL");
            System.out.println(title);
        }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    private static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        // TODO: print out the details of all the books (using JDBI)
        // See this page for details: http://jdbi.org
        // Use the "Book" class that we've created for you (in the models.database folder)

        Jdbi jdbi = Jdbi.create(connectionString);

        List<Book> users = jdbi.withHandle(handle -> {

            return handle.createQuery("SELECT * FROM bookish.Books")
                    .mapToBean(Book.class)
                    .list();
        });

        System.out.println(users.get(0).getAuthor());



    }
}
