package org.bitbucket.perscholas.utils.jdbc.database;

import org.bitbucket.perscholas.utils.jdbc.connection.*;
import org.bitbucket.perscholas.utils.jdbc.executor.StatementExecutor;

import javax.persistence.EntityManager;
import java.sql.Connection;

/**
 * Created by leon on 3/13/18.
 * decoration of DatabaseInterface; Implementation has been loosely coupled to `DatabaseImpl`
 */
public enum Database implements DatabaseInterface {
    POKEMON(new ConnectionBuilder()
  
            .setHost("127.0.0.1")
            .setUser("root")
            .setDatabaseVendor("mariadb")
            .setPassword("")),

    UAT(new ConnectionBuilder()
            .setDatabaseVendor("mysql")
            .setHost("127.0.0.1")
            .setUser("root")
            .setPassword(""));

    static { // Attempt to register JDBC Driver
        DatabaseInterface.registerJDBCDriver();
    }

    private final DatabaseImpl database;

    Database(ConnectionBuilderInterface connectionBuilderInterface) {
        this.database = new DatabaseImpl(connectionBuilderInterface, name());
    }

    public synchronized Connection getConnection() {
        return database.getConnection();
    }

    @Override
    public String getName() {
        return database.getName();
    }

    @Override
    public ConnectionBuilderInterface getConnectionBuilder() {
        return database.getConnectionBuilder();
    }

    @Override
    public StatementExecutor getStatementExecutor() {
        return database.getStatementExecutor();
    }

    @Override
    public ConnectionWrapper getConnectionWrapper() {
        return database.getConnectionWrapper();
    }

    @Override
    public DatabaseTable getTable(String tableName) {
        return database.getTable(tableName);
    }

    @Override
    public EntityManager getEntityManager() {
        return database.getEntityManager();
    }
}
