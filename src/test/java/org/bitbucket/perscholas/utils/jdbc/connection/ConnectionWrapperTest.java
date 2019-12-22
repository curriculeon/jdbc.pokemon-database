package org.bitbucket.perscholas.utils.jdbc.connection;

import org.junit.Before;

import java.sql.Connection;

public class ConnectionWrapperTest {
    private ConnectionWrapper wrapper;

    @Before
    public void setup() {
        Connection connection = new ConnectionBuilder()
                .setHost("127.0.0.1")
                .setDatabaseVendor("mysql")
                .setUser("root")
                .setPassword("")
                .build();
        this.wrapper = new ConnectionWrapper(connection);
    }
}
