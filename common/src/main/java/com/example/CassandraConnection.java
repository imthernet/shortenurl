package com.example;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Component
public class CassandraConnection implements AutoCloseable {
    private CqlSession session;
    @Value("${cassandra.node}")
    private String node;

    @Value("${cassandra.port}")
    private Integer port;

    @Value("${cassandra.datacenter}")
    private String datacenter;


    public void connect(String node, Integer port, String datacenter) {
        try {
            session = CqlSession.builder()
                    .addContactPoint(new InetSocketAddress(node, port))
                    .withLocalDatacenter(datacenter)
                    .build();
        } catch (Exception e) {
            // Handle the exception
            throw new RuntimeException("Failed to connect to Cassandra", e);
        }
    }

    public CqlSession getSession() {
        return this.session;
    }

    @Override
    public void close() {
        if (session != null) {
            session.close();
        }
    }
}


