package com.example;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import org.springframework.stereotype.Component;
import com.example.CassandraConnection;

@Component
public class UrlDecoder {
    private final CassandraConnection connection;

    public UrlDecoder(CassandraConnection connection) {
        this.connection = connection;
    }

    public String decodeFromBase32(String shortCode) {
        try (CqlSession session = connection.getSession()) {
            SimpleStatement statement = SimpleStatement.builder("SELECT long_url FROM my_keyspace.urls WHERE short_code = ?")
                    .addPositionalValue(shortCode)
                    .build();
            ResultSet resultSet = session.execute(statement);
            Row row = resultSet.one();
            if (row != null) {
                return row.getString("long_url");
            } else {
                return "URL not found";
            }
        }
    }
}
