package org.bitbucket.perscholas.utils.jdbc.dbseed;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        MigrationsTableTest.class,
        LeonDatabaseSeederTest.class,
})
public class DatabaseSeederTestSuite {
}
