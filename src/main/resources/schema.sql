DROP TABLE IF EXISTS Account;

CREATE TABLE Account(
    Id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(255) NOT NULL,
    balance NUMERIC NOT NULL
)