package org.bitbucket.perscholas.utils.jdbc.database;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by leon on 12/22/2019.
 */
public class DatabaseTypeAdapterTest {
    // given
    private void toEquivalentSQLTypeTest(Class<?> someType, String expectedType) {
        // when
        String actualType = DatabaseTypeAdapter.toSQLEquivalentType(someType);

        // then
        Assert.assertEquals(expectedType, actualType);
    }

    @Test
    public void testIntegerToEquivalentSQLType() {
        toEquivalentSQLTypeTest(Integer.class, "INT");
    }

    @Test
    public void  testStringToEquivalentSQLType() {
        toEquivalentSQLTypeTest(String.class, "TEXT");
    }


    @Test
    public void testDateToEquivalentSQLType() {
        toEquivalentSQLTypeTest(Date.class, "DATETIME");
    }
}
