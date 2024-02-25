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
    book VARCHAR(250) UNIQUE NOT NULL,
    publishing_house_id INTEGER REFERENCES publishing_house(house_id)
);

CREATE TABLE IF NOT EXISTS publishing_house
(
    house_id SERIAL PRIMARY KEY,
    name VARCHAR(250) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS book_author
(
    book_id INTEGER REFERENCES book(book_id),
    author_id INTEGER REFERENCES author(author_id)
);

