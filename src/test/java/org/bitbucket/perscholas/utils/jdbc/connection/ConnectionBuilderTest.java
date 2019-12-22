package org.bitbucket.perscholas.utils.jdbc.connection;

import org.junit.Assert;
import org.junit.Test;

public class ConnectionBuilderTest {

    @Test
    public void buildMySqlConnection()  {
        new ConnectionBuilder()
                .setDatabaseVendor("mysql")
                .setHost("127.0.0.1")
                .setUser("root")
                .setPassword("")
                .build();
    }

    @Test
    public void buildMariaDbConnection() {
        new ConnectionBuilder()
                .setDatabaseVendor("mariadb")
                .setHost("127.0.0.1")
                .setUser("root")
                .setPassword("")
                .build();
    }

    @Test
    public void mariaDbConnectionToString() {
        String actual =new ConnectionBuilder()
                .setDatabaseVendor("mariadb")
                .setHost("127.0.0.1")
                .setUser("root")
                .setPassword("")
                .toString();

        String expected = "jdbc:mariadb://127.0.0.1/";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sqlDbConnectionToString() {
        String actual = new ConnectionBuilder()
                .setDatabaseVendor("mysql")
                .setHost("127.0.0.1")
                .setUser("root")
                .setPassword("")
                .toString();

        String expected = "jdbc:mysql://127.0.0.1/";
        Assert.assertEquals(expected, actual);
    }
}
