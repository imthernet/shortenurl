-- Create the keyspace
CREATE KEYSPACE IF NOT EXISTS my_keyspace WITH replication = {
    'class': 'SimpleStrategy',
    'replication_factor' : 1
};

-- Create a table
CREATE TABLE IF NOT EXISTS my_keyspace.urls (
    short_code text PRIMARY KEY,
    long_url text
);

-- Insert some initial data (optional)
INSERT INTO my_keyspace.urls (short_code, long_url) VALUES ('abcd1234', 'http://example.com');