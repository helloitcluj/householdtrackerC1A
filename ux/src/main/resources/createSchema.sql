DROP SCHEMA PUBLIC CASCADE;

CREATE TABLE account (
  id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(30) UNIQUE,
  password  VARCHAR(30)
);

CREATE TABLE expense (
  id INTEGER IDENTITY PRIMARY KEY,
  amount DOUBLE,
  date DATE,
  description VARCHAR(30),
  accountId INTEGER NOT NULL
);