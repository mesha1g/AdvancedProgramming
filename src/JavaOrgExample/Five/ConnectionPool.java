package JavaOrgExample.Five;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static JavaOrgExample.Four.Collection.Dao.*;


public class ConnectionPool {

    private static final int POOL_SIZE = 10;
    private List<Connection> connectionPool = new ArrayList<>();
    private List<Connection> usedConnections = new ArrayList<>();

    private ConnectionPool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                Connection connection = createConnection(URL, USERNAME, PASSWORD);
                connectionPool.add(connection);
            } catch (SQLException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }

    public Connection getConnection() {
        if (connectionPool.isEmpty()) {
            throw new RuntimeException("Nema jarane više konekcija u bazenu");
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public void releaseConnection(Connection connection) {
        connectionPool.add(connection);
        usedConnections.remove(connection);
    }

    private Connection createConnection(String url, String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    // SINGLETON -> ANTI PATTERNOM
    private static ConnectionPool instance;

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }
}

