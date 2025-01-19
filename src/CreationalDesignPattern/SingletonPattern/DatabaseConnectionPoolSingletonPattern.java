package CreationalDesignPattern.SingletonPattern;

import java.util.ArrayList;
import java.util.List;

// ================== 1. SINGLETON PATTERN ==================

class Connection {
    private int connectionId;
    public Connection(int connectionId) {}
    public int getConnectionId() {
        return connectionId;
    }
}

/*
Problem Statement:
- A database connection pool needs to be managed across the application
- Only one instance should exist to prevent resource waste and ensure consistency
- All components need to access the same instance

Without Pattern (Problems):
- Multiple connection pools could be created
- No guarantee of single instance
- Resource wastage and potential conflicts
*/

// Bad Example (Without Pattern)
class DatabaseConnectionPool {
    private List<Connection> connections;

    public DatabaseConnectionPool() {
        connections = new ArrayList<>();
        // Initialize connections
    }

    public Connection getConnection() {
        // Return connection
        return null;
    }
}
// Problem: Each class can create its own pool
// DatabaseConnectionPool pool1 = new DatabaseConnectionPool();
// DatabaseConnectionPool pool2 = new DatabaseConnectionPool(); // Another instance!

// Good Example (With Singleton Pattern)
public class DatabaseConnectionPoolSingletonPattern {
    private static DatabaseConnectionPoolSingletonPattern instance;
    private List<Connection> connections;

    private DatabaseConnectionPoolSingletonPattern() {
        connections = new ArrayList<>();
        // Initialize connections
    }

    public static synchronized DatabaseConnectionPoolSingletonPattern getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionPoolSingletonPattern();
        }
        return instance;
    }

    public Connection getConnection() {
        // Return connection
        return null;
    }
}
// Usage:
// DatabaseConnectionPoolSingletonPattern pool1 = DatabaseConnectionPool.getInstance();
// DatabaseConnectionPoolSingletonPattern pool2 = DatabaseConnectionPool.getInstance(); // Same instance!
