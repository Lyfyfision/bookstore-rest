CREATE TABLE IF NOT EXISTS author
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS publisher
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(150) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS book
(
    id SERIAL PRIMARY KEY,
    title VARCHAR(150) UNIQUE NOT NULL,
    price float NOT NULL,
    author_id INT REFERENCES author(id),
    publisher_id INT REFERENCES publisher(id)
);

CREATE TABLE IF NOT EXISTS book_publisher
(
    book_id INTEGER REFERENCES book(id) ON UPDATE CASCADE,
    publisher_id INTEGER REFERENCES publisher(id) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (book_id, publisher_id)
);

