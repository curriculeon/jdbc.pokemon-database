package org.bitbucket.perscholas.utils.jdbc.connection;

import org.bitbucket.perscholas.utils.jdbc.database.Database;
import org.bitbucket.perscholas.utils.jdbc.testutils.SeedRefresher;
import org.bitbucket.perscholas.utils.jdbc.resultset.ResultSetHandler;
import org.junit.Before;
import org.junit.Test;

public class ResultSetHandlerTest {
    @Before
    public void setup() {
        SeedRefresher.refresh(Database.UAT);
    }

    @Test
    public void test() {
        ResultSetHandler rsh = Database.UAT.getTable("person").all();
        System.out.println(rsh.toStack());
    }
}
