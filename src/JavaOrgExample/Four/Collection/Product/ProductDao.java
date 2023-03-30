package JavaOrgExample.Four.Collection.Product;



import JavaOrgExample.Five.ConnectionPool;
import JavaOrgExample.Four.Collection.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <li>1. mysql driver</li>
 * <li>2. jdbc
 * 2.1 Connection
 * 2.2 Statement, PreparedStatement
 * 2.3 ResultSet
 * </li>
 */
public class ProductDao implements Dao<Product> {
    //SQL : INSERT
    @Override
    public Product create(Product entity) {
        return null;
    }

    //SQL: SELECT * FROM products;
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getLong("product_id"));
                product.setName(resultSet.getString(2));
                product.setQuantityInStock(resultSet.getInt("quantity_in_stock"));
                product.setUnitPrice(resultSet.getBigDecimal("unit_price"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return products;
    }

    //SQL: SELECT * FROM WHERE pr  ?
    @Override
    public Product get(long primaryKey) {

        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            Connection connection = connectionPool.getConnection();
            connectionPool.releaseConnection(connection);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE product_id=?");

            preparedStatement.setLong(1, primaryKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getLong("product_id"));
                product.setName(resultSet.getString(2));
                product.setQuantityInStock(resultSet.getInt("quantity_in_stock"));
                product.setUnitPrice(resultSet.getBigDecimal("unit_price"));
                return product;
            }

        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return null;
    }


    //SQL: UPDATE
    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void delete(Product entity) {

    }
}

