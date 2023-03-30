package JavaOrgExample.Three.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * SELECT * FROM customers;
 * <li>
 * java.sql.DriverManager
 * java.sql.Connection
 * 1. povezat se s bazom podataka
 * 1.1 URL ... jdbc:mydriver:imebaze
 * 1.2 username: root
 * 1.3 password: root
 * 1.4 driver---MySQL
 * </li>
 * <li>
 * <p>
 * java.sql.Statement, java.sql.PreparedStatement
 * 2. poslati ovaj upit: SELECT *FROM customers;
 * 2.1
 * </li>
 * <li>
 * java.sql.ResultSet
 * 3. procesirati rezultate upita
 *
 * </li>
 */
public class CustomerMySQLReader {
    public static final String URL = "jdbc:mysql://localhost:3306/store";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public List<Customer> loadCustomers() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        //1. ostvariti konekciju
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //2. kreiranje upita
        Statement statement = connection.createStatement();
        //3. procesiranje upita
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
        while (resultSet.next()) {
            Customer customer = new Customer();
            int customerId = resultSet.getInt("customer_id");
            customer.setCustomerId(customerId);
            String firstName = resultSet.getString("first_name");
            customer.setFirstName(firstName);
            String lastName = resultSet.getString(3);
            customer.setLastName(lastName);
            Date birthDate = resultSet.getDate("birth_date");
            customer.setBirthdate(birthDate.toLocalDate());
            String phone = resultSet.getString("phone");
            customer.setPhone(phone);
            customer.setAddress(resultSet.getString("address"));
            customer.setCity(resultSet.getString("city"));
            customer.setState(resultSet.getString("state"));
            customer.setPoints(resultSet.getInt("points"));
            customerList.add(customer);
        }
        return customerList;
    }
}

