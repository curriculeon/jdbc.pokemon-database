package org.bitbucket.perscholas.utils.jdbc.dbseed;

import org.bitbucket.perscholas.utils.jdbc.database.Database;
import org.bitbucket.perscholas.utils.jdbc.database.DatabaseInterface;
import org.bitbucket.perscholas.utils.jdbc.database.DatabaseTable;
import org.bitbucket.perscholas.utils.jdbc.resultset.ResultSetHandler;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

public class LeonDatabaseSeederTest {
    private LeonDatabaseSeeder seeder;
    private DatabaseInterface database;

    @Before
    public void setup() {
        this.database = Database.UAT;
        database.drop();
        database.create();
        database.use();
        database.disableLogging();
    }

    @Test
    public void test() {
        // Given
        Connection connection = database.getConnection();
        this.seeder = new LeonDatabaseSeeder(connection);

        // When
        seeder.importFilesFromResourcesDirectory();

        // Then
        DatabaseTable pokemons = database.getTable("pokemons");
        ResultSetHandler rsh  = pokemons.select("*");
        System.out.println(rsh);
    }

}
