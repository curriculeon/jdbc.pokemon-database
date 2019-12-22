package org.bitbucket.perscholas.utils.jdbc.resultset;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author leon on 3/24/18.
 */
public interface ResultExtractor<T> {
    List<T> extract(ResultSet resultSet);
}
