package org.bitbucket.perscholas.utils.jdbc.database;

import org.bitbucket.perscholas.pokemondatabase.model.Pokemon;
import org.bitbucket.perscholas.utils.jdbc.connection.ConnectionBuilder;
import org.junit.Test;

public class DatabaseTableStatementGeneratorTest {
    @Test
    public void test1() {
        System.out.println(new DatabaseTableStatementGenerator(Database.UAT, Pokemon.class).getCreateStatement());
    }
}
