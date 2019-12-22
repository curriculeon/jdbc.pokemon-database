package org.bitbucket.perscholas.utils.jdbc.testutils;

import org.bitbucket.perscholas.utils.jdbc.database.Database;
import org.bitbucket.perscholas.utils.jdbc.database.DatabaseInterface;

public class SeedRefresher {
    @Deprecated
    public static void refreshPokemonDatabase() {
        refresh(Database.POKEMON);
    }

    public static void refresh() {
        refresh(Database.UAT);
    }

    public static void refresh(DatabaseInterface database) {
        database.drop();
        database.create();
        database.use();
    }
}