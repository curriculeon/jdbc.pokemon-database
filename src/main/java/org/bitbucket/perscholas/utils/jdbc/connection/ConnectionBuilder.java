package org.bitbucket.perscholas.utils.jdbc.connection;

import com.github.git_leon.StringAssembler;
import gitleon.utils.exceptionalfunctionalinterface.ExceptionalSupplier;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBuilder implements ConnectionBuilderInterface {
    private Integer portNumber;
    private String userName;
    private String userPass;
    private String databaseVendor;
    private String hostName;
    private String databaseName;


    @Override
    public ConnectionBuilder setPort(Integer portNumber) {
        this.portNumber = portNumber;
        return this;
    }

    @Override
    public ConnectionBuilder setDatabaseVendor(String databaseVendor) {
        this.databaseVendor = databaseVendor;
        return this;
    }

    @Override
    public ConnectionBuilder setHost(String hostName) {
        this.hostName = hostName;
        return this;
    }

    @Override
    public ConnectionBuilder setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    @Override
    public ConnectionBuilder setUser(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public ConnectionBuilder setPassword(String userPass) {
        this.userPass = userPass;
        return this;
    }

    @Override
    public Connection build() {
        String errorMessage = "Failed to connect to `%s`";
        String jdbcUrl = this.toString();

        return ExceptionalSupplier.tryInvoke(
                () -> DriverManager.getConnection(jdbcUrl, this.userName, this.userPass),
                String.format(errorMessage, jdbcUrl));
    }

    @Override
    public String toString() {
        Boolean isHostNull = this.hostName == null;
        Boolean isPortNull = portNumber == null;
        Boolean hasPortBeenSet = !isPortNull && !Integer.valueOf(3306).equals(portNumber);

        String jdbcUrl = new StringAssembler()
                .append("jdbc:")
                .nonNullAppend(this.databaseVendor)
                .append("://")
                .conditionalAppend(isHostNull, "localhost")
                .conditionalAppend(!isHostNull, this.hostName)
                .conditionalAppend(hasPortBeenSet, ":")
                .conditionalAppend(hasPortBeenSet, portNumber)
                .append("/")
                .nonNullAppend(databaseName)
                .toString();
        return jdbcUrl;
    }
}