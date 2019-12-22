package org.bitbucket.perscholas.utils.jdbc.connection;

import java.sql.Connection;

public interface ConnectionBuilderInterface {
    ConnectionBuilder setPort(Integer portNumber);

    ConnectionBuilder setDatabaseVendor(String databaseVendor);

    ConnectionBuilder setHost(String hostName);

    ConnectionBuilder setDatabaseName(String databaseName);

    ConnectionBuilder setUser(String userName);

    ConnectionBuilder setPassword(String userPass);

    Connection build();
}
