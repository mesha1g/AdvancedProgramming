package JavaOrgExample.Four.Collection;


import JavaOrgExample.Three.JDBC.Customer;

import java.util.List;

/**
 * CRUD
 * <p>
 *     Create
 *     Retrieve
 *     Update
 *     Delete
 * </p>
 * @param <E>
 */
public interface Dao<E> {
    String URL = "jdbc:mysql://localhost:3306/store";
    String USERNAME = "root";
    String PASSWORD = "root";

    E create(E entity);

    List<E> getAll();

    E get(long primaryKey);

    E update(E entity);

    void delete(E entity);
}