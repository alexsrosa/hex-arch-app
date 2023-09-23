#!/bin/bash

set -e
export PGPASSWORD=$POSTGRES_PASSWORD;

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL

  CREATE USER user_${NAME_DB}_admin WITH PASSWORD '$PASS_DB';
  CREATE USER user_${NAME_DB}_app WITH PASSWORD '$PASS_DB';

  CREATE DATABASE $NAME_DB OWNER user_${NAME_DB}_admin;

  GRANT ALL PRIVILEGES ON DATABASE $NAME_DB TO user_${NAME_DB}_admin;
  GRANT ALL PRIVILEGES ON DATABASE $NAME_DB TO user_${NAME_DB}_app;

EOSQL

psql --username "user_${NAME_DB}_admin" -c "ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL PRIVILEGES ON TABLES TO user_${NAME_DB}_app" "${NAME_DB}"