package JavaOrgExample.Four.Collection.Customer;



import JavaOrgExample.Four.Collection.Dao;
import JavaOrgExample.Three.JDBC.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * java.io
 * java.sql
 * <li>1. java.sql.Connection</li>
 * <li>2. java.sql.Statement, java.sql.PreparedStatement, java.sql.CallableStatement
 * </li>
 * <li>3. java.sql.ResultSet</li>
 *
 *         //1. povezati s bazom
 *         //2. kreirati sql statement i izvršiti ga
 *         //3. procesirati rezultate izvršavanja upita nad bazom
 */
public class CustomerDao implements Dao<Customer> {
    @Override
    public Customer create(Customer entity) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString(3));
                Date birthDate = resultSet.getDate("birth_date");
                customer.setBirthdate(birthDate.toLocalDate());
                customer.setPhone(resultSet.getString("phone"));
                customer.setAddress(resultSet.getString("address"));
                customer.setCity(resultSet.getString("city"));
                customer.setState(resultSet.getString("state"));
                customer.setPoints(resultSet.getInt("points"));

                customers.add(customer);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return customers;
    }

    @Override
    public Customer get(long primaryKey) {
        Customer customer = new Customer();
        //SELECT * FROM customers WHERE customer_id=?
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE customer_id=?");
            preparedStatement.setLong(1, primaryKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString(3));
                Date birthDate = resultSet.getDate("birth_date");
                customer.setBirthdate(birthDate.toLocalDate());
                customer.setPhone(resultSet.getString("phone"));
                customer.setAddress(resultSet.getString("address"));
                customer.setCity(resultSet.getString("city"));
                customer.setState(resultSet.getString("state"));
                customer.setPoints(resultSet.getInt("points"));
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return customer;
    }

    @Override
    public Customer update(Customer entity) {
        return null;
    }

    @Override
    public void delete(Customer entity) {

    }
}
