package org.bitbucket.perscholas.pokemondatabase;

import org.bitbucket.perscholas.pokemondatabase.model.Pokemon;
import org.bitbucket.perscholas.utils.jdbc.database.Database;
import org.bitbucket.perscholas.utils.jdbc.database.DatabaseInterface;
import org.bitbucket.perscholas.utils.jdbc.database.DatabaseTable;
import org.bitbucket.perscholas.utils.jdbc.database.DatabaseTableStatementGenerator;
import org.bitbucket.perscholas.utils.jdbc.executor.StatementExecutorInterface;

/**
 * Created by leon on 12/8/2019.
 */
public class MainApplication {
    public static void main(String[] args) {
        DatabaseInterface database = Database.UAT;
        database.drop();
        database.create();
        database.use();

        Pokemon pokemonToAddToDatabase = new Pokemon(52L , "Pikachu", 9, null);
        Class<? extends Pokemon> classToPersist = pokemonToAddToDatabase.getClass();
        DatabaseTableStatementGenerator statementGenerator = new DatabaseTableStatementGenerator(database, classToPersist);
        DatabaseTable table = database.getTable(classToPersist.getSimpleName());

        StatementExecutorInterface statementExecutor = database.getStatementExecutor();
        String createStatement = statementGenerator.getCreateStatement();
        String insertionStatement = statementGenerator.getInsertionStatement(pokemonToAddToDatabase);
        String insertionStatementHardCoded = "INSERT INTO UAT.pokemon (id, name, primaryType, secondaryType) VALUES (1, 'Smeargle', 1, null);";

        statementExecutor.executeAndCommit(createStatement);
        statementExecutor.executeAndCommit(insertionStatementHardCoded);
//        statementExecutor.executeAndCommit(insertionStatement);

        System.out.println(table.all());
    }
}
