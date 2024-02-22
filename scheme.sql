CREATE TABLE IF NOT EXISTS book
(
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(250) UNIQUE NOT NULL,
    author VARCHAR(250) NOT NULL,
    price float NOT NULL
);

CREATE TABLE IF NOT EXISTS author
(
    author_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) UNIQUE NOT NULL,
    book VARCHAR(250) UNIQUE NOT NULL
);