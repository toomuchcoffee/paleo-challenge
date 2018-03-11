Database setup for local development

    start postgres server
    open psql console
        CREATE DATABASE paleodb;
        CREATE USER paleo WITH PASSWORD 'nograins';
        GRANT ALL PRIVILEGES ON DATABASE "paleodb" TO paleo;
