CREATE TABLE IF NOT EXISTS author
(
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS publisher
(
    publisher_id SERIAL PRIMARY KEY,
    name VARCHAR(150) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS book
(
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(150) UNIQUE NOT NULL,
    price float NOT NULL,
    author_id INT NOT NULL REFERENCES author(author_id)
);

CREATE TABLE IF NOT EXISTS book_publisher
(
    book_id INTEGER REFERENCES book(book_id) ON UPDATE CASCADE ON DELETE CASCADE,
    publisher_id INTEGER REFERENCES publisher(publisher_id) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (book_id, publisher_id)
);

INSERT INTO author (name)
VALUES (unnest(array['King', 'Dostoevsky', 'Pushkin', 'Allan Poe', 'Lovecraft']));

INSERT INTO publisher (name)
VALUES (unnest(array['house1', 'house2', 'house3', 'house4', 'house5']));

INSERT INTO book (title, price, author_id)
VALUES ('Good book', 12.53, 1);

INSERT INTO book (title, price, author_id)
VALUES ('Good book part 2', 14.80, 1);

INSERT INTO book (title, price, author_id)
VALUES ('SOme another book', 8, 3);

INSERT INTO book_publisher (book_id, publisher_id)
VALUES (1, 1), (2, 2), (1,3), (2,1), (2,5), (3,5);
